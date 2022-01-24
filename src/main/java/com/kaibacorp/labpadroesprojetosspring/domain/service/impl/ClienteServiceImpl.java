package com.kaibacorp.labpadroesprojetosspring.domain.service.impl;

import com.kaibacorp.labpadroesprojetosspring.api.dto.ClienteDTO;
import com.kaibacorp.labpadroesprojetosspring.core.mapper.ClienteInputMapper;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Cliente;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Endereco;
import com.kaibacorp.labpadroesprojetosspring.domain.exception.DontFoundException;
import com.kaibacorp.labpadroesprojetosspring.domain.repository.ClienteRepository;
import com.kaibacorp.labpadroesprojetosspring.domain.repository.EnderecoRepository;
import com.kaibacorp.labpadroesprojetosspring.domain.service.ClienteService;
import com.kaibacorp.labpadroesprojetosspring.domain.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    private ClienteInputMapper clienteInputMapper;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(()->new DontFoundException("Não contramos o usuário com id: "+ id));
    }

    @Override
    public void inserir(Cliente cliente) {
        var cep = cliente.getEndereco().getCep();
        var endereco = enderecoRepository
                .findById(cep)
                .orElseGet(()->validacaoEndereco(cep));
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente clienteAtualizado) {
        buscarPorId(id);
        clienteAtualizado.setId(id);
        String cep = clienteAtualizado.getEndereco().getCep();
        var endereco = enderecoRepository
                .findById(cep)
                .orElseGet(()->validacaoEndereco(cep));
        clienteAtualizado.setEndereco(endereco);
        clienteRepository.save(clienteAtualizado);
    }

    @Override
    public void deletar(Long id) {
        var cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }

    private Endereco validacaoEndereco(String cep){
        Endereco novoEndereco = viaCepService
                .consultarCEP(cep)
                .orElseThrow(()->new DontFoundException("Não contramos o endereço com CEP: "+ cep));
        enderecoRepository.save(novoEndereco);
        return novoEndereco;
    }
}
