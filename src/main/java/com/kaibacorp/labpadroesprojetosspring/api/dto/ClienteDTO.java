package com.kaibacorp.labpadroesprojetosspring.api.dto;

import com.kaibacorp.labpadroesprojetosspring.domain.entity.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @Schema(description = "Entre com o nome",example = "Caio Oliveira")
    private String nome;
    @Schema(description = "Entre com o CEP",example = "38413024")
    private String cep;
}
