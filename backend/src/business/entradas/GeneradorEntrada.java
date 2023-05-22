package business.entradas;

import business.clases.Entrada;
import business.clases.Espacio;
import business.clases.dto.EntradaDTO;
import com.google.zxing.WriterException;
import dataAccess.googleMapsGateway.GoogleMapsGateway;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @charset UTF-8
 */
public class GeneradorEntrada {

    private static String pathPlantilla = "resources/entradas/plantillaEntrada.png";


    public static BufferedImage generarEntradas(EntradaDTO infoEntrada) throws IOException, WriterException {

        // Cargar la plantilla de entrada
        File plantilla = new File(pathPlantilla);
        BufferedImage entrada = ImageIO.read(plantilla);

        // Crear un objeto Graphics2D para dibujar en la imagen de entrada
        Graphics2D g2d = entrada.createGraphics();

        // Definir la fuente y el color para el texto
        loadFont();
        Font font = new Font("Anton", Font.BOLD, 89);
        Color color = Color.white;

        // Dibujar el nombre en la entrada
        g2d.setFont(font);
        g2d.setColor(color);
        g2d.drawString(infoEntrada.getNombre().toUpperCase(), 551, 153);

        // Dibuja el precio en la entrada
        String precio = String.valueOf(infoEntrada.getPrecio().getPrecio());
        g2d.drawString(precio, 551, 520);

        // Dibujar la información en la entrada
        font = new Font("Anton", Font.BOLD, 32);
        g2d.setFont(font);
        //Espacio espacio = infoEntrada.getEvento().getEspacio();
        //GoogleMapsGateway g = new GoogleMapsGateway();
        //String informacion = espacio.getNombre() + " - "+ g.getCodigoPostal(espacio.getDireccion());
        g2d.drawString("PENDIENTE", 551, 303);

        // Cargar el código QR generado
        BufferedImage codigoQR = GeneradorQR.generarQR(infoEntrada.getQr());

        // Dibuja el código QR en la entrada
        g2d.drawImage(codigoQR, 75, 129, 385, 390, null);

        // Libera los recursos del objeto Graphics2D
        g2d.dispose();

        // Guarda la entrada generada
        //File entradaGenerada = new File("temp/Entrada.png");
        //ImageIO.write(entrada, "png", entradaGenerada);

        return entrada;
    }

    private static void loadFont() {
        boolean fontAlreadyInstalled = false;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
        for (Font font : fonts) {
            if (font.getName().equals("Anton") && font.getStyle() == Font.PLAIN) {
                fontAlreadyInstalled = true;
                break;
            }
        }
        if (!fontAlreadyInstalled) {
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/entradas/fonts/Anton-Regular.ttf"));
                ge.registerFont(font);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
    }

}