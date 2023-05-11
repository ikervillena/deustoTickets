package business.entradas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GeneradorQR {

    private static final int QR_CODE_IMAGE_SIZE = 256;

    public static BufferedImage generarQR(String texto) throws WriterException {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, QR_CODE_IMAGE_SIZE, QR_CODE_IMAGE_SIZE, hints);
        int width = bitMatrix.getWidth();
        BufferedImage qrImage = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
        qrImage.createGraphics();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                qrImage.setRGB(i, j, bitMatrix.get(i, j) ? 0x000000 : 0xFFFFFF);
            }
        }

        return qrImage;
    }

    public static void guardarQR(String texto, String filePath) throws WriterException, IOException {
        BufferedImage qrImage = generarQR(texto);
        File qrFile = new File(filePath);
        ImageIO.write(qrImage, "png", qrFile);
    }

}
