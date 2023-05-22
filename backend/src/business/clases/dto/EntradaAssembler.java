package business.clases.dto;

import business.clases.Entrada;
import dataAccess.rest.client.TicketProviderGateway;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;

@NoArgsConstructor
public class EntradaAssembler {

    public EntradaDTO assemble(Entrada entrada) throws IOException {
        TicketProviderGateway g = new TicketProviderGateway();
        ClienteDTO c = new ClienteDTO(); // PENDIENTE
        return new EntradaDTO(entrada.getQr(), entrada.getNombre(), entrada.getFecCompra(), g.getPrecio(entrada.getIdPrecio()),
                g.getEvento(entrada.getIdEvento()), c, entrada.isUtilizada());
    }

    public ArrayList<EntradaDTO> assemble(ArrayList<Entrada> entradas) throws IOException{
        ArrayList<EntradaDTO> a = new ArrayList<>();
        for(Entrada e : entradas) {
            a.add(this.assemble(e));
        }
        return a;
    }

    public Entrada getEntrada(EntradaDTO dto) {
        return new Entrada(dto.getQr(), dto.getNombre(), dto.getFecCompra(), dto.getPrecio().getId(),
                dto.getEvento().getId(), dto.getCliente().getDni(), dto.isUtilizada());
    }
}
