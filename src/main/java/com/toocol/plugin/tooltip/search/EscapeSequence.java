package com.toocol.plugin.tooltip.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 20:57
 */
public class EscapeSequence {
    public final int start;
    public final int end;
    public final String escapeSequence;

    private final Collection<IEscapeMode> escapeModes = new ArrayList<>();

    public EscapeSequence(int start, int end, String escapeSequence) {
        this.start = start;
        this.end = end;
        this.escapeSequence = escapeSequence;
    }

    public void add(IEscapeMode mode) {
        escapeModes.add(mode);
    }

    public Collection<IEscapeMode> getEscapeModes() {
        return escapeModes;
    }
}
