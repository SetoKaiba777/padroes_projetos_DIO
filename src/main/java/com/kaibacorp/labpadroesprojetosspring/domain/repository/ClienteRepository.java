package com.kaibacorp.labpadroesprojetosspring.domain.repository;

import com.kaibacorp.labpadroesprojetosspring.domain.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
