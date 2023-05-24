package presentation.gui;

import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ThreadLectorQR implements Runnable {

    private WebcamPanel webcamPanel;
    private JTextField textField;
    public boolean isRunning;

    public ThreadLectorQR(WebcamPanel webcamPanel) {
        this.webcamPanel = webcamPanel;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                BufferedImage image = this.webcamPanel.getWebcam().getImage();
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
                String codigoQR = new MultiFormatReader().decode(bitmap).getText();

                // PENDIENTE: HAY QUE COMPROBAR QUE EL QR CORRESPONDE LA EVENTO Y TODAVIA NO HA
                // SIDO UTILIZADO

                // boolean utilizarEntrada(EntradaDTO) me marca con esto que la entrada esta
                // utilizada, le tengo que pasar la entrada con el campo de utilizada cambiado.
                System.out.println("Codigo QR: " + codigoQR); // Temporal
                mostrarCorrecto(); // Esto hay que hacerlo tras comprobar que es valido
            } catch (Exception e) {
            }
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    public void mostrarCorrecto() {
        // Cargar la imagen
        ImageIcon icon = new ImageIcon("resources/images/escaneoCorrecto.png");
        JLabel label = new JLabel(icon);
        webcamPanel.add(label);
        // Situar la imagen en el centro de la camara
        int x = (webcamPanel.getWidth() - icon.getIconWidth()) / 2;
        int y = (webcamPanel.getHeight() - icon.getIconHeight()) / 2;
        label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        webcamPanel.repaint();
        // Esperar 3 segundos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Quitar la imagen
        webcamPanel.remove(label);
        webcamPanel.repaint();
    }

}
