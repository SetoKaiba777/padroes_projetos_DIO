package com.kaibacorp.labpadroesprojetosspring.core.mapper;

import com.kaibacorp.labpadroesprojetosspring.api.dto.ClienteDTO;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Cliente;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Endereco;


public class ClienteInputMapper {

    public Cliente toModel(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        endereco.setCep(clienteDTO.getCep());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(endereco);
        return cliente;
    }

}

