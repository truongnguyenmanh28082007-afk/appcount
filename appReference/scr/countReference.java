package scr;

import java.io.File;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class countReference {

    // đếm từ trong PDF
    public int countWord(File file, String keyword) {
        int count = 0;

        try (PDDocument document = Loader.loadPDF(file)) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document).toLowerCase();
            keyword = keyword.toLowerCase();

            int index = text.indexOf(keyword);
            while (index != -1) {
                count++;
                index = text.indexOf(keyword, index + keyword.length());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}