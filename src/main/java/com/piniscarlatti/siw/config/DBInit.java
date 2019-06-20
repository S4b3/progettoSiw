package com.piniscarlatti.siw.config;

import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.CarrelloRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {
    @Autowired
    private FunzionarioRepository funzionarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CarrelloRepository carrelloRepository;

    @Override
    public void run(String... args) {
        // Delete all
        /*
        Carrello carrello = new Carrello();
        this.carrelloRepository.save(carrello);
        Funzionario funz = new Funzionario("funzionario",passwordEncoder.encode("password"),carrello);
        this.funzionarioRepository.save(funz);
        */

        // Create funz
    }
}