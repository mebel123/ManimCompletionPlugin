package de.mebel123.manimplugin;

import com.intellij.lang.Language;

public class ManimLanguage extends Language {
    public static final ManimLanguage INSTANCE = new ManimLanguage();

    private ManimLanguage() {
        super("Manim");
    }
}
