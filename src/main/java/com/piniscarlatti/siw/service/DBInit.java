package com.piniscarlatti.siw.Service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBInit implements CommandLineRunner {
    @Autowired
    private FunzionarioRepository funzionarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all
        this.funzionarioRepository.deleteAll();

        // Create funz
        Funzionario funz = new Funzionario("user", passwordEncoder.encode("password"));

        // Save to db
        this.funzionarioRepository.save(funz);
    }
}