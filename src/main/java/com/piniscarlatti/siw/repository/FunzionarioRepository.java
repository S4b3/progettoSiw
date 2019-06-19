package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Funzionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunzionarioRepository extends JpaRepository<Funzionario,Long> {
    Funzionario findByUsername(String username);

    boolean existsByUsername(String username);
}
