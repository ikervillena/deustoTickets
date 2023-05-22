package business.entradas.enviarStrategy;

import business.clases.Cliente;
import business.clases.Entrada;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

import static business.entradas.GeneradorPDF.generarPDF;

public class EnvioEmail implements IEnviarStrategy{

    private static String remitente = "deustotickets@outlook.es";
    private static String password = "VentaDeEntradas";

    private static String servidorSMTP = "smtp.office365.com";
    private static String puertoSMTP = "587";

    @Override
    public boolean enviar(ClienteDTO cliente, ArrayList<EntradaDTO> entradas, String direccion) {
        boolean plural;
        plural = (entradas.size()>1)?true:false;
        String asunto = "¡Gracias por tu compra! Tu entrada para "+entradas.get(0).getEvento().getTitulo()+" está aquí";
        String mensaje = "¡Hola "+cliente.getNombre()+"!\n\n" +
                "Te escribo para darte las gracias por comprar "+((plural)?"entradas":"una entrada")+" para nuestro evento "+entradas.get(0).getEvento().getTitulo()+". Estamos emocionados de tenerte con nosotros y esperamos que disfrutes de la experiencia.\n\n" +
                "Adjunto encontrarás "+((plural)?"tus entradas":"tu entrada")+" con su código QR correspondiente. Por favor, asegúrate de tenerla a mano en tu móvil o impreso para poder ingresar al evento. Recuerda que el código QR es único y solo puede ser utilizado una vez.\n\n" +
                "¡No te olvides de seguirnos en nuestras redes sociales para estar al tanto de todas las novedades y sorpresas que tenemos preparadas para ti!\n\n" +
                "Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos. Estamos aquí para ayudarte.\n\n" +
                "¡Nos vemos pronto en el evento!\n\n" +
                "Saludos cordiales,\n\n" +
                "Equipo de DeustoTickets";

        // Configurar la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puertoSMTP);

        // Crear la sesión de correo electrónico
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);
        try {
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cliente.getEmail()));
            message.setSubject(asunto);
            // Crear el cuerpo del mensaje
            BodyPart mensajeBodyPart = new MimeBodyPart();
            mensajeBodyPart.setText(mensaje);

            // Generate the PDF
            byte[] pdfBytes = generarPDF(entradas);

            // Adjuntar PDF con las entradas
            BodyPart archivoAdjunto = new MimeBodyPart();
            archivoAdjunto.setDataHandler(new DataHandler(new ByteArrayDataSource(pdfBytes, "application/pdf")));
            archivoAdjunto.setFileName("Entradas.pdf");


            // Combinar el cuerpo del mensaje y el archivo adjunto en un multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensajeBodyPart);
            multipart.addBodyPart(archivoAdjunto);

            // Asignar el multipart al mensaje y enviarlo
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(servidorSMTP, remitente, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            System.out.println(e);
            return false;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
