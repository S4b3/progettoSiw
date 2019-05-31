package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/gallery")
public class GalleryController implements WebMvcConfigurer {


    @Autowired
    FotografoRepository fotografoRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping
    public String getGallery(){
        return "gallery";
    }


    @GetMapping("/albums")
    public String getAlbumsGallery(){
        return "galleryAlbums";
    }

    @GetMapping("/photos")
    public String getPhotosGallery(){
        return "galleryFoto";
    }


}