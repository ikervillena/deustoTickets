package business.entradas.enviarStrategy;

import business.clases.Cliente;
import business.clases.Entrada;
import business.entradas.GeneradorPDF;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnvioTelegram extends TelegramLongPollingBot implements IEnviarStrategy {

    private String username = "DeustoTickets_bot";
    private String token = "6229099927:AAGt71kHvV9guRG733hsaIzgEIOav3zlzP8";
    @Override
    public boolean enviar(Cliente cliente, ArrayList<Entrada> entradas, String direccion) {
        try {
            execute(new SendMessage(direccion, "Hola "+cliente.getNombre()+"! Gracias por tu compra!"));
            execute(new SendMessage(direccion, "Te adjunto tus entradas en formato PDF. Asegurate de guardar el archivo " +
                    "y tenerlo a mano para el evento. Si tienes alguna pregunta o necesitas mas informacion, " +
                    "no dudes en contactarnos. Disfruta de la experiencia!"));
            execute(new SendDocument(direccion, new InputFile(new ByteArrayInputStream(GeneradorPDF.generarPDF(entradas)), "Entradas.pdf")));
        } catch (TelegramApiException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        // Devolver el nombre de usuario del bot
        return username;
    }

    @Override
    public String getBotToken() {
        // Devolver el token de acceso del bot
        return token;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
