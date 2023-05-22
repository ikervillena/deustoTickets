package business.entradas;

import business.clases.Entrada;
import business.clases.dto.EntradaDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

public class GeneradorPDF {

    private static final float PAGE_WIDTH = PDRectangle.A4.getWidth();
    private static final float PAGE_HEIGHT = PDRectangle.A4.getHeight();
    private static final float MARGIN = 50;
    private static final float ENTRY_WIDTH = PAGE_WIDTH - 2 * MARGIN;
    private static final float ENTRY_HEIGHT = PAGE_HEIGHT - 2 * MARGIN;
    private static final float ENTRY_SPACING = 10;

    public static byte[] generarPDF(ArrayList<EntradaDTO> entradas) throws IOException {
        PDDocument document = new PDDocument();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        for (EntradaDTO e : entradas) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setLineWidth(1);

            float startY = PAGE_HEIGHT - MARGIN;
            float currentY = startY;

            BufferedImage entrada = null;
            try {
                entrada = GeneradorEntrada.generarEntradas(e);
            } catch (WriterException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // Escalar y dibujar la entrada en la página del PDF
            float scale = Math.min(ENTRY_WIDTH / entrada.getWidth(), ENTRY_HEIGHT / entrada.getHeight());
            float imageWidth = entrada.getWidth() * scale;
            float imageHeight = entrada.getHeight() * scale;
            float startX = MARGIN + (ENTRY_WIDTH - imageWidth) / 2;
            currentY -= imageHeight;

            // Save the image to a temporary file
            File tempFile = File.createTempFile("temp", ".png");
            ImageIO.write(entrada, "png", tempFile);

            PDImageXObject image = PDImageXObject.createFromFileByExtension(tempFile, document);
            contentStream.drawImage(image, startX, currentY, imageWidth, imageHeight);

            contentStream.close();

            // Delete the temporary file
            tempFile.delete();
        }

        document.save(outputStream);
        document.close();

        return outputStream.toByteArray();
    }
}
