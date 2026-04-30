package Main;

import gui.PDFSearchApp;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PDFSearchApp().setVisible(true);
        });
    }
}