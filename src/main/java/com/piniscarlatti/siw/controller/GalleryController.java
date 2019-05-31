package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

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
    public String gallery(){
        return "gallery.html";
    }

    @GetMapping("/photographers")
    public String showForm(Fotografo fotografo){
        return "formFotografo";
    }

    @PostMapping("/photographers")
    public String insertFotografo(@Valid Fotografo fotografo, BindingResult bindingResult){

        try{
            fotografo.setAlbumBase();
            fotografoRepository.save(fotografo);
        }catch (Exception e){
            return "formFotografo";
        }

        return "redirect:/results";
    }

    @GetMapping("/deletephotographers")
    public String showDeleteButton(){
        return "deleteFotografo";
    }


    @PostMapping("/deletephotographers")
    public  String deleteAllFotografi(){
        fotografoRepository.deleteAll();
        return "results";
    }

    @GetMapping("/photographers/{name}")
    @ResponseBody
    public List<Fotografo> findByName(@PathVariable String name){
        return fotografoRepository.findByNome(name);
    }

    @GetMapping("/photographers/all")
    @ResponseBody
    public List<Fotografo> findAll(){
        return fotografoRepository.findAll();
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