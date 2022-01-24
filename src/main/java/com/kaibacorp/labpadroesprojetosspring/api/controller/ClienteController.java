package com.kaibacorp.labpadroesprojetosspring.api.controller;

import com.kaibacorp.labpadroesprojetosspring.api.dto.ClienteDTO;
import com.kaibacorp.labpadroesprojetosspring.core.mapper.ClienteInputMapper;
import com.kaibacorp.labpadroesprojetosspring.domain.entity.Cliente;
import com.kaibacorp.labpadroesprojetosspring.domain.service.impl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    private ClienteInputMapper clienteInputMapper = new ClienteInputMapper();

    @GetMapping
    @Operation(summary = "Retorna uma lista com todos os clientes")
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna o cliente com id específico")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo cliente")
    public ResponseEntity<Cliente> inserir(@RequestBody ClienteDTO clienteDTO){
        var cliente = clienteInputMapper.toModel(clienteDTO);
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza cliente com id específico")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        var cliente = clienteInputMapper.toModel(clienteDTO);
        clienteService.atualizar(id,cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta cliente com id específico")
    public ResponseEntity<Void> deletar(Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
