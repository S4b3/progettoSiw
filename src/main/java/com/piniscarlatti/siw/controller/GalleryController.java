package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.service.FotoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/gallery")
@AllArgsConstructor
public class GalleryController implements WebMvcConfigurer {

    private FotografoRepository fotografoRepository;
    private FotoServiceImpl fotoService;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("visualizzaFotografi");
    }

    @GetMapping
    public String allPhotos(Model model){
        model.addAttribute("fotografie",fotoService.trovaTutte());
        return "galleryPhotos";
    }

    //Cancellazione di tutti i fotografi dal db
    @GetMapping("/deletephotographers")
    public String showDeleteButton(){
        return "deleteFotografo";
    }

    @PostMapping("/deletephotographers")
    public  String deleteAllFotografi() {
        fotografoRepository.deleteAll();
        return "visualizzaFotografi";
    }


}