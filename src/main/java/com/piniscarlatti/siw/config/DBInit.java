package com.piniscarlatti.siw.config;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.entity.Utente;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private FunzionarioRepository funzionarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all

        // Create funz
        Funzionario funz = new Funzionario("funzionario", passwordEncoder.encode("password"));
        Utente utente = new Utente("utente", passwordEncoder.encode("password"));

        // Save to db
        this.funzionarioRepository.save(funz);
        this.utenteRepository.save(utente);
    }
}