package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Fotografo;
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
@RequestMapping("/photographers")
@AllArgsConstructor
public class FotografoController implements WebMvcConfigurer {

    private FotografoServiceImpl fotografoService;
    //Visualizza fotografi
    @GetMapping
    public String loadFotografi(Model model) {
        model.addAttribute("fotografi", fotografoService.getAllFotografi());
        return "visualizzaFotografi";
    }
    //visualizza fotografi per iniziali
    @GetMapping("/{value}")
    public String loadByInitial(@RequestParam("value") String value,Model model){
        model.addAttribute("fotografi", fotografoService.getFotografiStartingWith(value.toUpperCase()));
        return "visualizzaFotografi";
    }
    @GetMapping("/{id}/details")
    public String showDetails(@PathVariable("id")Long id,Model model){
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("fotografo",fotografo);
        return "dettagliFotografo";
    }

}