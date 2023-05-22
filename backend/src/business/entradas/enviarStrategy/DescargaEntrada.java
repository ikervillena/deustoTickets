package business.entradas.enviarStrategy;

import business.clases.Cliente;
import business.clases.Entrada;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;
import business.entradas.GeneradorPDF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DescargaEntrada implements IEnviarStrategy{
    @Override
    public boolean enviar(ClienteDTO cliente, ArrayList<EntradaDTO> entradas, String direccion) {
        try {
            byte[] pdfBytes = GeneradorPDF.generarPDF(entradas);
            FileOutputStream fileOutputStream = new FileOutputStream(direccion);
            fileOutputStream.write(pdfBytes);
            fileOutputStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
