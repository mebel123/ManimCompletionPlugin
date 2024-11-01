package de.mebel123.manimplugin;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;

public class ManimCompletionContributor extends CompletionContributor {
    public ManimCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(PsiElement.class), new ManimCompletionProvider());
    }
}
