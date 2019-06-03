package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gallery/photographers")
public class FotografoController implements WebMvcConfigurer {


    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    AlbumRepository albumRepository;


    //aggiunta di un fotografo
    @GetMapping
    public String showForm(Fotografo fotografo, Model model) {
        return "formFotografo";
    }

    @PostMapping
    public RedirectView insertFotografo(@Valid Fotografo fotografo, BindingResult bindingResult, Model model) {

        try {
            fotografo.setAlbumBase();
            fotografoRepository.save(fotografo);

        } catch (Exception e) {

            return new RedirectView("/gallery/photographers");
        }

        List<Fotografo> fotografi = new ArrayList<>(fotografoRepository.findAll());
        model.addAttribute("fotografi", fotografi);
        return new RedirectView("/gallery/photographers/all");
    }

    //Cancellazione singolo fotografo
    @GetMapping("/delete/{id}")
    public String deletePhotographers(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
        fotografoRepository.delete(fotografo);
        model.addAttribute("fotografi", fotografoRepository.findAll());
        return "visualizzaFotografi";
    }

    //Modifica dati fotografo
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));

        model.addAttribute("fotografo", fotografo);
        return "modificaFotografo";
    }

    @PostMapping("/update/{id}")
    public String updateFotografo(@PathVariable("id") Long id, @Valid Fotografo fotografo,
                                  BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            fotografo.setId(id);
            return "modificaFotografo";
        }*/

        fotografoRepository.save(fotografo);
        model.addAttribute("fotografi", fotografoRepository.findAll());
        return "visualizzaFotografi";
    }


    //visualizza fotografi
    @GetMapping("/all")
    public String loadRes(Model model) {
        List<Fotografo> fotografi = new ArrayList<>(fotografoRepository.findAll());
        model.addAttribute("fotografi", fotografi);
        return "visualizzaFotografi";
    }


}