package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@RequestMapping("/gallery/album")
public class AlbumController implements WebMvcConfigurer {


    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    AlbumRepository albumRepository;


    //aggiunta album
    @GetMapping("/album/{id}")
    public String addAlbum(@PathVariable("id") Long id, Model model) {

        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));

        model.addAttribute("albums", albumRepository.findByFotografo(fotografo));
        return "visualizzaAlbum";
    }

}