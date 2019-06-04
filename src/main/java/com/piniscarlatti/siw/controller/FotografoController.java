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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/photographers")
public class FotografoController implements WebMvcConfigurer {

    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    AlbumRepository albumRepository;

    //Visualizza fotografi
    @GetMapping
    public String loadRes(Model model) {
        List<Fotografo> fotografi = new ArrayList<>(fotografoRepository.findAll());
        model.addAttribute("fotografi", fotografi);
        return "visualizzaFotografi";
    }
    //Aggiunta di un fotografo
    @GetMapping("/add")
    public String showForm(Fotografo fotografo, Model model) {

        return "formFotografo";
    }
    @PostMapping("/add")
    public ModelAndView insertFotografo(@Valid Fotografo fotografo, BindingResult bindingResult, Model model) {

        boolean emailExist = fotografoRepository.existsByEmail(fotografo.getEmail());
        if (bindingResult.hasErrors() || emailExist)
            return new ModelAndView("formFotografo", "emailExist", emailExist);

        fotografo.setAlbumBase();
        fotografoRepository.save(fotografo);

        model.addAttribute("fotografi", fotografoRepository.findAll());
        return new ModelAndView("redirect:/photographers");
    }
    //Cancellazione singolo fotografo
    @GetMapping("/{id}/delete")
    public RedirectView deletePhotographers(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
        fotografoRepository.delete(fotografo);
        model.addAttribute("fotografi", fotografoRepository.findAll());
        return new RedirectView("/photographers");
    }
    //Modifica dati fotografo
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));

        boolean emailExist = fotografoRepository.existsByEmail(fotografo.getEmail());

        model.addAttribute("emailExist",emailExist);
        model.addAttribute("fotografo", fotografo);
        return "modificaFotografo";
    }
    @PostMapping("/{id}/update")
    public ModelAndView updateFotografo(@PathVariable("id") Long id, @Valid Fotografo fotografo, BindingResult result, Model model) {

        boolean emailExist = fotografoRepository.existsByEmail(fotografo.getEmail());
        if (result.hasErrors() || emailExist)
            return new ModelAndView("redirect:/photographers/{id}/edit");

        fotografoRepository.save(fotografo);
        model.addAttribute("fotografi", fotografoRepository.findAll());
        return new ModelAndView("redirect:/photographers");
    }

}