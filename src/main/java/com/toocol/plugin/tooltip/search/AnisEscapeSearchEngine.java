package com.toocol.plugin.tooltip.search;

import com.intellij.psi.PsiElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 21:14
 * @version: 0.0.1
 */
public class AnisEscapeSearchEngine {
    private static final Logger logger = LoggerFactory.getLogger(AnisEscapeSearchEngine.class);
    private static final AnisEscapeSearchEngine instance = new AnisEscapeSearchEngine();

    public static AnisEscapeSearchEngine get() {
        return instance;
    }

    private static final Pattern wordNumberPattern = Pattern.compile("\\w+");
    private static final Pattern numberPattern = Pattern.compile("\\d+");
    private static final Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
    private static final Pattern codeStringPattern = Pattern.compile("(\\d{1,3};){1,2}[\\\\\"'\\w ]+;?");
    private static final Pattern codePattern = Pattern.compile("(\\d{1,3};)+");
    private static final Pattern stringPattern = Pattern.compile("[\\w ]+;?");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#cursor-controls
    private static final Pattern cursorSetPosModePattern = Pattern.compile("\\\\u001[bB]\\[\\d{1,4};\\d{1,4}[Hf]");
    private static final Pattern cursorControlModePattern = Pattern.compile("(\\\\u001[bB]\\[\\d{0,4}[HABCDEFGsu]|(6n))|(\\\\u001[bB] [M78])");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#erase-functions
    private static final Pattern eraseFunctionModePattern = Pattern.compile("\\\\u001[bB]\\[[0123]?[JK]");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#colors--graphics-mode
    private static final Pattern colorGraphicsModePattern = Pattern.compile("\\\\u001[bB]\\[((?!38)(?!48)\\d{1,3};?)+m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#256-colors
    private static final Pattern color256ModePattern = Pattern.compile("\\\\u001[bB]\\[(38)?(48)?;5;\\d{1,3}m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#rgb-colors
    private static final Pattern colorRgbModePattern = Pattern.compile("\\\\u001[bB]\\[(38)?(48)?;2;\\d{1,3};\\d{1,3};\\d{1,3}m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#set-mode
    private static final Pattern screenModePatter = Pattern.compile("\\\\u001[bB]\\[=\\d{1,2}h");
    private static final Pattern disableScreenModePattern = Pattern.compile("\\\\u001[bB]\\[=\\d{1,2}l");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#common-private-modes
    private static final Pattern commonPrivateModePattern = Pattern.compile("\\\\u001[bB]\\[\\?\\d{2,4}[lh]");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#keyboard-strings
    private static final Pattern keyBoardStringModePattern = Pattern.compile("\\\\u001[bB]\\[((\\d{1,3};){1,2}(((\\\\\")|'|\")[\\w ]+((\\\\\")|'|\");?)|(\\d{1,2};?))+p");

    public synchronized Collection<EscapeSequence> getEscapeSequence(PsiElement element) {
        Collection<EscapeSequence> collection = new ArrayList<>();
        var text = element.getText();

        regexParse(text, cursorSetPosModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var numMatcher = numberPattern.matcher(group);
                try {
                    if (!numMatcher.find()) continue;
                    var line = Integer.parseInt(numMatcher.group(0));
                    if (!numMatcher.find()) continue;
                    var column = Integer.parseInt(numMatcher.group(0));
                    EscapeCursorControlMode.codeOf("Hf")
                            .ifPresent(mode -> {
                                escapeSequence.add(mode
                                        .addParam(line).addParam(column)
                                        .addParam(line).addParam(column)
                                        .addParam(line).addParam(column)
                                        .generateTooltip()
                                );
                            });
                } catch (Exception e) {
                    logger.warn("Parse int number failed.");
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, cursorControlModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var wnMatcher = wordNumberPattern.matcher(group);
                if (wnMatcher.find()) {
                    var code = wnMatcher.group(0);
                    if (code.contains("A") || code.contains("B") || code.contains("C") || code.contains("D")
                            || code.contains("E") || code.contains("F") || code.contains("G")) {
                        var wMatcher = wordPattern.matcher(code);
                        if (wMatcher.find()) {
                            var icode = wMatcher.group(0);
                            EscapeCursorControlMode.codeOf(icode)
                                    .ifPresent(mode -> {
                                        var nMatcher = numberPattern.matcher(code);
                                        if (nMatcher.find()) {
                                            try {
                                                var param = Integer.parseInt(nMatcher.group(0));
                                                escapeSequence.add(mode.addParam(param).addParam(param).generateTooltip());
                                            } catch (Exception e) {
                                                logger.warn("Parse number failed.");
                                            }
                                        }
                                    });
                        }
                    } else {
                        EscapeCursorControlMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                    }
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, eraseFunctionModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                Matcher wnMatcher = wordNumberPattern.matcher(group);
                if (wnMatcher.find()) {
                    var code = wnMatcher.group(0);
                    EscapeEraseFunctionsMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, colorGraphicsModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var numMatcher = numberPattern.matcher(group);
                while (numMatcher.find()) {
                    var code = Integer.parseInt(numMatcher.group(0));
                    if (code < 30) {
                        // graphics mode
                        EscapeColorGraphicsMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                    } else if (code < 50) {
                        // 8-16 color mode
                        EscapeColor8To16Mode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                    } else if (code >= 90 && code <= 107) {
                        // iso color mode
                        EscapeColorISOMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                    }
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, color256ModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var nMatcher = numberPattern.matcher(group);
                if (!nMatcher.find()) continue;
                var foreground = nMatcher.group(0).equals("38");
                if (!nMatcher.find()) continue;
                var clz = nMatcher.group(0);
                if (!"5".equals(clz)) continue;
                if (!nMatcher.find()) continue;
                try {
                    var code = Integer.parseInt(nMatcher.group(0));
                    EscapeColor256Mode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.setForeground(foreground).generateTooltip()));
                } catch (Exception e) {
                    logger.warn("Parse int number failed.");
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, colorRgbModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var nMatcher = numberPattern.matcher(group);
                if (!nMatcher.find()) continue;
                var foreground = nMatcher.group(0).equals("38");
                if (!nMatcher.find()) continue;
                var clz = nMatcher.group(0);
                if (!"2".equals(clz)) continue;
                try {
                    if (!nMatcher.find()) continue;
                    var r = Integer.parseInt(nMatcher.group(0));
                    if (!nMatcher.find()) continue;
                    var g = Integer.parseInt(nMatcher.group(0));
                    if (!nMatcher.find()) continue;
                    var b = Integer.parseInt(nMatcher.group(0));
                    escapeSequence.add(EscapeColorRgbMode.COLOR_RGB_MODE
                            .setForeground(foreground)
                            .addParam(r).addParam(g).addParam(b)
                            .addParam(r).addParam(g).addParam(b)
                            .generateTooltip()
                    );
                } catch (Exception e) {
                    logger.warn("Parse int number failed.");
                }
                collection.add(escapeSequence);
            }
        });

        regexParse(text, screenModePatter, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var nMatcher = numberPattern.matcher(group);
                if (!nMatcher.find()) continue;
                var code = Integer.parseInt(nMatcher.group(0));
                EscapeScreenMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                collection.add(escapeSequence);
            }
        });

        regexParse(text, disableScreenModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var nMatcher = numberPattern.matcher(group);
                if (!nMatcher.find()) continue;
                var code = Integer.parseInt(nMatcher.group(0));
                EscapeScreenMode.codeOf(code).ifPresent(mode -> escapeSequence.add("<b>Disable</b> " + mode.generateTooltip()));
                collection.add(escapeSequence);
            }
        });

        regexParse(text, commonPrivateModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                var wnMatcher = wordNumberPattern.matcher(group);
                if (!wnMatcher.find()) continue;
                var code = wnMatcher.group(0);
                EscapeCommonPrivateMode.codeOf(code).ifPresent(mode -> escapeSequence.add(mode.generateTooltip()));
                collection.add(escapeSequence);
            }
        });

        regexParse(text, keyBoardStringModePattern, matcher -> {
            while (matcher.find()) {
                var group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                var escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001[bB]", "");
                logger.warn("get group {}", group);
                var codeStringMatcher = codeStringPattern.matcher(group);
                while (codeStringMatcher.find()) {
                    var codeString = codeStringMatcher.group(0);
                    logger.warn("get codeString {}", codeString);

                    var codeMatcher = codePattern.matcher(codeString);
                    if (!codeMatcher.find()) continue;
                    var code = codeMatcher.group(0);
                    logger.warn("get code {}", code);

                    var stringMatcher = stringPattern.matcher(codeString.replaceAll(code, ""));
                    if (!stringMatcher.find()) continue;
                    var string = stringMatcher.group(0);
                    logger.warn("get string {}", string);

                    code = code.charAt(code.length() - 1) == ';' ? code.substring(0, code.length() - 1) : code;
                    string = string.charAt(string.length() - 1) == ';' ? string.substring(0, string.length() - 1) : string;
                    escapeSequence.add(EscapeKeyBoardStringMode.KEY_BOARD_STRING_MODE.setCode(code).setString(string).generateTooltip());
                }
                collection.add(escapeSequence);
            }
        });

        return collection;
    }

    private void regexParse(String text, Pattern pattern, Consumer<Matcher> consumer) {
        consumer.accept(pattern.matcher(text));
    }

    private AnisEscapeSearchEngine() {

    }
}
