package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.repository.FotoRepository;
import com.piniscarlatti.siw.service.AmazonClient;
import com.piniscarlatti.siw.service.ImageStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ControllerAdvice
public class AmazonController {

    private static final Logger logger = LoggerFactory.getLogger("logger");

    @Autowired
    private FotoRepository fotorepo;

    @Autowired
    private ImageStorageService imgStorage;

    @GetMapping("/addfoto")
    public String addfoto(){
        logger.info("Loggo qualcosa dal controller " + this.imgStorage.toString());
        return "addfoto";
    }

    @PostMapping("/submitfoto")
    public String submit(@RequestParam("file") MultipartFile file){
        String url = imgStorage.storeImage(file);
        logger.info(url);
        fotorepo.save(new Foto("pika", url));
        return "addfoto";
    }
}

