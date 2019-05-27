package com.piniscarlatti.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @GetMapping
    public String getGallery(){
        return "gallery";
    }

    @GetMapping("/photographers")
    public String getPhotographersGallery(){
        return "galleryFotografi";
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
