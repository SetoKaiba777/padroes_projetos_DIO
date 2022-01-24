package com.kaibacorp.labpadroesprojetosspring.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id do Usuário",example = "1")
    private long id;
    @Schema(description = "Nome do Usuário",example = "Caio")
    private String nome;
    @ManyToOne
    private Endereco endereco;
}
