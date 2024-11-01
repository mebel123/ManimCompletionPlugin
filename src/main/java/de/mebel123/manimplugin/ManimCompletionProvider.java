package de.mebel123.manimplugin;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ManimCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();

        PsiElement parentElement = PsiTreeUtil.getParentOfType(position, PsiElement.class);

        if (parentElement != null) {
            String parentText = parentElement.getText();

            if (parentText.contains("play")) {
                result.addElement(LookupElementBuilder.create("run_time"));
                result.addElement(LookupElementBuilder.create("rate_func"));
                result.addElement(LookupElementBuilder.create("smooth"));
                result.addElement(LookupElementBuilder.create("linear"));
                result.addElement(LookupElementBuilder.create("rush_from"));
                result.addElement(LookupElementBuilder.create("rush_into"));
                result.addElement(LookupElementBuilder.create("ease_in_out_quad"));
                result.addElement(LookupElementBuilder.create("ease_in_sine"));
                result.addElement(LookupElementBuilder.create("ease_out_sine"));
                result.addElement(LookupElementBuilder.create("there_and_back"));
            } else if (parentText.contains("Text") || parentText.contains("Arc") || parentText.contains("VGroup")) {
                result.addElement(LookupElementBuilder.create("move_to"));
                result.addElement(LookupElementBuilder.create("scale"));
                result.addElement(LookupElementBuilder.create("rotate"));
                result.addElement(LookupElementBuilder.create("next_to"));
                result.addElement(LookupElementBuilder.create("to_edge"));
                result.addElement(LookupElementBuilder.create("align_to"));
                result.addElement(LookupElementBuilder.create("shift"));
            }
        } else {
            addGeneralCompletions(result);
        }
    }

    private void addGeneralCompletions(CompletionResultSet result) {
        result.addElement(LookupElementBuilder.create("Scene"));
        result.addElement(LookupElementBuilder.create("Mobject"));
        result.addElement(LookupElementBuilder.create("Text"));
        result.addElement(LookupElementBuilder.create("Arc"));
        result.addElement(LookupElementBuilder.create("VGroup"));
        result.addElement(LookupElementBuilder.create("Circle"));
        result.addElement(LookupElementBuilder.create("Rectangle"));
        result.addElement(LookupElementBuilder.create("Line"));
        result.addElement(LookupElementBuilder.create("Polygon"));

        result.addElement(LookupElementBuilder.create("FadeIn"));
        result.addElement(LookupElementBuilder.create("FadeOut"));
        result.addElement(LookupElementBuilder.create("Create"));
        result.addElement(LookupElementBuilder.create("Uncreate"));
        result.addElement(LookupElementBuilder.create("Write"));
        result.addElement(LookupElementBuilder.create("DrawBorderThenFill"));
        result.addElement(LookupElementBuilder.create("ShowPassingFlash"));
        result.addElement(LookupElementBuilder.create("ShowCreationThenDestruction"));

        result.addElement(LookupElementBuilder.create("Transform"));
        result.addElement(LookupElementBuilder.create("ReplacementTransform"));
        result.addElement(LookupElementBuilder.create("ApplyMethod"));
        result.addElement(LookupElementBuilder.create("ApplyPointwiseFunction"));
        result.addElement(LookupElementBuilder.create("ApplyMatrix"));

        result.addElement(LookupElementBuilder.create("MoveCamera"));
        result.addElement(LookupElementBuilder.create("ZoomIn"));
        result.addElement(LookupElementBuilder.create("ZoomOut"));
        result.addElement(LookupElementBuilder.create("set_camera_orientation"));

        result.addElement(LookupElementBuilder.create("UP"));
        result.addElement(LookupElementBuilder.create("DOWN"));
        result.addElement(LookupElementBuilder.create("LEFT"));
        result.addElement(LookupElementBuilder.create("RIGHT"));
        result.addElement(LookupElementBuilder.create("PI"));
        result.addElement(LookupElementBuilder.create("TAU"));
        result.addElement(LookupElementBuilder.create("BLUE"));
        result.addElement(LookupElementBuilder.create("GREEN"));
        result.addElement(LookupElementBuilder.create("RED"));
        result.addElement(LookupElementBuilder.create("YELLOW"));
        result.addElement(LookupElementBuilder.create("WHITE"));
        result.addElement(LookupElementBuilder.create("BLACK"));
    }
}
