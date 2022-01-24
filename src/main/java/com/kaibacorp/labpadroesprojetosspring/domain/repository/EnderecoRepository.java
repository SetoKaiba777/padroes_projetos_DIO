package com.kaibacorp.labpadroesprojetosspring.domain.repository;

import com.kaibacorp.labpadroesprojetosspring.domain.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String> {
}
