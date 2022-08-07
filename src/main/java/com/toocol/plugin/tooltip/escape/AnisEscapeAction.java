package com.toocol.plugin.tooltip.escape;

import com.intellij.psi.PsiElement;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 21:17
 * @version: 0.0.1
 */
public abstract class AnisEscapeAction {

    public abstract void action(PsiElement element, String escapeSequence);

}
