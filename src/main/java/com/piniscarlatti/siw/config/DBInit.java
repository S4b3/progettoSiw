package com.piniscarlatti.siw.config;

import com.piniscarlatti.siw.entity.*;
import com.piniscarlatti.siw.repository.CarrelloRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DBInit implements CommandLineRunner {
    @Autowired
    FunzionarioRepository funzionarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CarrelloRepository carrelloRepository;
    @Autowired
    FotografoServiceImpl fotografoService;
    @Autowired
    AlbumServiceImpl albumService;
    @Autowired
    FotoServiceImpl fotoService;

    @Override
    public void run(String... args) {

        //TODO: PER LA PRIMA INIZIALIZZAZIONE DEL DB E' NECESSARIO DECOMMENTARE QUESTO CODICE.
        // RICOMMENTARLO IMMEDIATAMENTE DOPO PER EVITARE CRASH DI POSTGRESQL.
/*
        Carrello carrello = new Carrello();
        this.carrelloRepository.save(carrello);
        Funzionario funz = new Funzionario("funzionario",passwordEncoder.encode("password"),carrello);
        this.funzionarioRepository.save(funz);

        Carrello carrello1 = new Carrello();
        this.carrelloRepository.save(carrello1);
        Funzionario utente = new Funzionario("utente", passwordEncoder.encode("password"), "UTENTE", carrello1);
        this.funzionarioRepository.save(utente);

        Fotografo fotografo1 = new Fotografo("Steve", "McCurry", "info@stevemccurry.com");
        fotografoService.save(fotografo1);

        Fotografo fotografo2 = new Fotografo("Fotografo", "SenzaFoto", "nopic@gmail.com");

        Album album = new Album("Volti", fotografo1);
        albumService.save(album);

        Foto foto = new Foto("Anziano molto anziano", "https://siwpics.s3.eu-central-1.amazonaws.com/1561040283292-07c094d01177902cf8661f35cdc25d62_XL.jpg");
        foto.setCategoria("Volti");
        foto.setPrezzo(13.99);
        Foto foto1 = new Foto("Giovine Pakistana", "https://siwpics.s3.eu-central-1.amazonaws.com/1561040304655-PAKISTAN-10003.jpg");
        foto1.setCategoria("Volti");
        foto1.setPrezzo(18.99);
        Foto foto2 = new Foto("Bimbo McCurry", "https://siwpics.s3.eu-central-1.amazonaws.com/1561040344659-festival-of-ganesh-1280x640.jpg");
        foto2.setCategoria("Volti");
        foto2.setPrezzo(50.00);
        Foto foto3 = new Foto("Uomo Turbato", "https://siwpics.s3.eu-central-1.amazonaws.com/1561040327541-af20626b-811b-4aa8-bd95-020956f24455.jpg");
        foto3.setCategoria("Volti");
        foto3.setPrezzo(27.00);

        foto.setAlbum(album);
        foto1.setAlbum(album);
        foto2.setAlbum(album);
        foto3.setAlbum(album);

        fotoService.salva(foto);
        fotoService.salva(foto1);
        fotoService.salva(foto2);
        fotoService.salva(foto3);

*/


    }
}