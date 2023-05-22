package business.clases.dto;

import business.clases.Cliente;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class ClienteAssembler {

    public ClienteDTO assemble(Cliente cliente) throws IOException {
        EntradaAssembler a = new EntradaAssembler();
        return new ClienteDTO(cliente.getDni(),cliente.getNombre(), cliente.getApellido(),
                cliente.getUsuario(), cliente.getContrasenya(), cliente.getFecNac(), cliente.getEmail(),
                a.assemble(cliente.getEntradas()));
    }

    public Cliente getCliente(ClienteDTO dto) {
        return new Cliente(dto.getDni(), dto.getNombre(), dto.getApellido(),
                dto.getUsuario(), dto.getContrasenya(), dto.getFecNac(), dto.getEmail());
    }


}
