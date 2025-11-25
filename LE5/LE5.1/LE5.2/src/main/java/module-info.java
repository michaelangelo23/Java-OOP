module hangman {
    requires javafx.controls;
    requires transitive javafx.graphics;

    exports hangman.console;
    exports hangman.core;
    exports hangman.gui;
}
