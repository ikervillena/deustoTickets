package presentation.gui;

import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import business.clases.Evento;
import business.clases.dto.EntradaDTO;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ThreadLectorQR implements Runnable {

    private WebcamPanel webcamPanel;
    private JTextField textField;
    private Evento evento;
    public boolean isRunning;

    public ThreadLectorQR(WebcamPanel webcamPanel, Evento evento) {
        this.webcamPanel = webcamPanel;
        this.evento = evento;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                BufferedImage image = this.webcamPanel.getWebcam().getImage();
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
                String codigoQR = new MultiFormatReader().decode(bitmap).getText();

                ArrayList<EntradaDTO> entradas = this.evento.getEntradas();

                boolean encontrado = false;

                for (int i = 0; i < entradas.size(); i++) {
                    if (entradas.get(i).getQr().equals(codigoQR)) {
                        if (entradas.get(i).isUtilizada()) {
                            mostrarCorrecto();
                        } else {
                            mostrarInCorrecto();
                        }
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    mostrarInCorrecto();
                }
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

    public void mostrarInCorrecto() {
        // Cargar la imagen
        ImageIcon icon = new ImageIcon("resources/images/escaneo.png");
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
