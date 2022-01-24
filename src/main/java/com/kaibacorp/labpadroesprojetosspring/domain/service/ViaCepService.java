package com.kaibacorp.labpadroesprojetosspring.domain.service;

import com.kaibacorp.labpadroesprojetosspring.domain.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="viacep",url="https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json")
    Optional<Endereco> consultarCEP(@PathVariable("cep") String cep);
}
