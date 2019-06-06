package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotografoRepository extends JpaRepository<Fotografo, Long> {

    List<Fotografo> findByNomeContainsOrCognomeContainsOrEmailContains(String nome,String nome1,String nome2);
    boolean existsByEmail(String email);
    
}
