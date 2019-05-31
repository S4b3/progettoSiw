package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Funzionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunzionarioRepository extends JpaRepository<Funzionario,Long> {
    public Funzionario findFunzionarioByUsername(String username);
}
