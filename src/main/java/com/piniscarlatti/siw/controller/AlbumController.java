package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.service.AlbumServiceImpl;
import com.piniscarlatti.siw.service.FotografoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@RequestMapping("/photographers/{id}/album")
@AllArgsConstructor
public class AlbumController implements WebMvcConfigurer {

    private AlbumServiceImpl albumService;
    private FotografoServiceImpl fotografoService;

    //visualizzazione
    @GetMapping
    public String seeAlbum(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("albums", albumService.getAlbumsByFotografo(fotografo));
        model.addAttribute("fotografo", fotografo);
        return "visualizzaAlbum";
    }
    //visualizza fotografi per iniziali
    @GetMapping("/{value}")
    public String loadByInitial(@RequestParam("value") String value,@PathVariable("id") Long id, Model model){
        model.addAttribute("albums", albumService.getAlbumsByTitolo(fotografoService.getFotografoById(id),value.toUpperCase()));
        model.addAttribute("fotografo",fotografoService.getFotografoById(id));
        return "visualizzaAlbum";
    }
}