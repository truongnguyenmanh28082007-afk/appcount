package gui;

import scr.OpenFile;
import scr.countReference;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class PDFSearchApp extends JFrame {

    private JLabel label;
    private JButton btnOpen;
    private JButton btnReset;

    private OpenFile openService = new OpenFile();
    private countReference countService = new countReference();

    public PDFSearchApp() {
        setTitle("App đọc và đếm từ Reference trong PDF");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        label = new JLabel("Chọn file PDF", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        JPanel panel = new JPanel();

        btnOpen = new JButton("Open PDF");
        btnReset = new JButton("Reset");

        panel.add(btnOpen);
        panel.add(btnReset);

        add(panel, BorderLayout.SOUTH);

        // mở file + đếm
        btnOpen.addActionListener(e -> openFile());

        btnReset.addActionListener(e -> {
            label.setText("Chọn file PDF");
            label.setForeground(Color.BLACK);
        });
    }

    private void openFile() {
        File file = openService.chooseFile(this);

        if (file != null) {
            if (openService.isPDF(file)) {

                int count = countService.countWord(file, "reference");

                label.setForeground(new Color(0, 102, 204));
                label.setText("<html><center>File: " + file.getName()
                        + "<br>Số từ 'reference': " + count + "</center></html>");

            } else {
                label.setForeground(Color.RED);
                label.setText("Không phải file PDF!");
            }
        }
    }
}