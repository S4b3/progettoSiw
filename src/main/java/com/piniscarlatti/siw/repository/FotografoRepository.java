package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FotografoRepository extends JpaRepository<Fotografo, Long> {

    Optional<Fotografo> findByEmail(String email);
    List<Fotografo> findByNome(String nome);
    boolean existsByEmail(String email);

}
