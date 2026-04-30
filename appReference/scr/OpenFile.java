package scr;

import java.io.File;
import javax.swing.*;

public class OpenFile {

    // mở file chooser
    public File chooseFile(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    // kiểm tra file PDF
    public boolean isPDF(File file) {
        return file.getName().toLowerCase().endsWith(".pdf");
    }
}