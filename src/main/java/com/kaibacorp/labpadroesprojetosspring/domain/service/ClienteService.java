package com.kaibacorp.labpadroesprojetosspring.domain.service;

import com.kaibacorp.labpadroesprojetosspring.api.dto.ClienteDTO;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
