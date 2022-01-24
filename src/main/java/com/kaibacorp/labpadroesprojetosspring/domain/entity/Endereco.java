package com.kaibacorp.labpadroesprojetosspring.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @Schema(description = "CEP",example = "38413024")
    private String cep;
    @Schema(description = "Logradouro",example = "Rua das Seringueiras")
    private String logradouro;
    @Schema(description = "Complemento", example = "")
    private String complemento;
    @Schema(description = "Bairro",example = "Jaraguá")
    private String bairro;
    @Schema(description = "Localidade", example = "Uberlândia")
    private String localidade;
    @Schema(description = "UF", example = "MG")
    private String uf;
    @Schema(description = "GIA", example = "")
    private String gia;
    @Schema(description = "DD", example = "34")
    private String ddd;
    @Schema(description = "SIAFI", example = "5403")
    private String siafi;
}
