package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Utente findByUsername(String username);
}
