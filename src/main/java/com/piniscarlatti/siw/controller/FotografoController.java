package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Controller
public class FotografoController implements WebMvcConfigurer {

    @Autowired
    FotografoRepository fotografoRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Fotografo fotografo) {
        return "formFotografo";
    }

    @PostMapping("/")
    public String checkPersonInfo(Fotografo fotografo) {


        try {
            fotografo.setAlbumBase();
            fotografoRepository.save(fotografo);
        } catch (Exception e) {

            return "form";
        }

        return "redirect:/results";
    }

}

