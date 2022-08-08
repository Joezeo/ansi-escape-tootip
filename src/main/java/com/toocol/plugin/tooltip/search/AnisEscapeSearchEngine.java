package com.toocol.plugin.tooltip.search;

import com.intellij.psi.PsiElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
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

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#cursor-controls
    private static final Pattern cursorSetPosModePattern = Pattern.compile("\\\\u001b\\[\\d{1,4};\\d{1,4}[Hf]");
    private static final Pattern cursorControlModePattern = Pattern.compile("\\\\u001b[\\[ ]\\d{0,4}([HABCDEFGM78su]|(6n))");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#erase-functions
    private static final Pattern eraseFunctionModePattern = Pattern.compile("\\\\u001b\\[[0123]?[JK]");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#colors--graphics-mode
    private static final Pattern colorGraphicsModePattern = Pattern.compile("\\\\u001b\\[((?!38)(?!48)\\d{1,3};?)+m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#256-colors
    private static final Pattern color256ModePattern = Pattern.compile("\\\\u001b\\[(38)?(48)?;5;\\d{1,3}m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#rgb-colors
    private static final Pattern colorRgbModePattern = Pattern.compile("\\\\u001b\\[(38)?(48)?;2;\\d{1,3};\\d{1,3};\\d{1,3}m");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#set-mode
    private static final Pattern screenModePatter = Pattern.compile("\\\\u001b\\[=\\d{1,2}h");
    private static final Pattern disableScreenModePattern = Pattern.compile("\\\\u001b\\[=\\d{1,2}l");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#common-private-modes
    private static final Pattern commonPrivateMode = Pattern.compile("\\\\u001b\\[\\?\\d{2,4}[lh]");

    // see: https://gist.github.com/Joezeo/ce688cf42636376650ead73266256336#keyboard-strings
    private static final Pattern keyBoardStringMode = Pattern.compile("\\\\u001b\\[((\\d{1,3};)(\\d{1,3};)([\"\\w ]+;?))+p");

    public synchronized Collection<EscapeSequence> getEscapeAction(PsiElement element) {
        Collection<EscapeSequence> collection = new ArrayList<>();
        var text = element.getText();

        regexParse(text, cursorSetPosModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, cursorControlModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, eraseFunctionModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, colorGraphicsModePattern, matcher -> {
            while (matcher.find()) {
                String group = matcher.group(0);
                var start = element.getTextRange().getStartOffset() + matcher.start(0);
                var end = start + group.length();
                EscapeSequence escapeSequence = new EscapeSequence(start, end, group);

                group = group.replaceAll("\\\\u001b", "");
                Matcher numMatcher = numberPattern.matcher(group);
                while (numMatcher.find()) {
                    var code = Integer.parseInt(numMatcher.group(0));
                    if (code < 30) {
                        // graphics mode
                        escapeSequence.add(EscapeColorGraphicsMode.codeOf(code));
                    } else if (code < 50) {
                        // 8-16 color mode
                        escapeSequence.add(EscapeColor8To16Mode.codeOf(code));
                    } else if (code >= 90 && code <= 107) {
                        // iso color mode
                        escapeSequence.add(EscapeColorISOMode.codeOf(code));
                    }
                }
                collection.add(escapeSequence);
            }
            return null;
        }).ifPresent(collection::add);

        regexParse(text, color256ModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, colorRgbModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, screenModePatter, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, disableScreenModePattern, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, commonPrivateMode, matcher -> {
            return null;
        }).ifPresent(collection::add);

        regexParse(text, keyBoardStringMode, matcher -> {
            return null;
        }).ifPresent(collection::add);

        logger.warn("collection size = {}", collection.size());
        return collection;
    }

    private Optional<EscapeSequence> regexParse(String text, Pattern pattern, Function<Matcher, EscapeSequence> func) {
        var matcher = pattern.matcher(text);
        return Optional.ofNullable(func.apply(matcher));
    }

    private AnisEscapeSearchEngine() {

    }
}
