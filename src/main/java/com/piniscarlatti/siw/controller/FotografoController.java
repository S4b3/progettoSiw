package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.Service.FotografoServiceImpl;
import com.piniscarlatti.siw.entity.Fotografo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
@Controller
@RequestMapping("/photographers")
@AllArgsConstructor
public class FotografoController implements WebMvcConfigurer {

    private FotografoServiceImpl fotografoService;
    //Visualizza fotografi
    @GetMapping
    public ModelAndView loadFotografi() {
        return new ModelAndView("visualizzaFotografi","fotografi", fotografoService.getAllFotografi());
    }
    //visualizza fotografi per iniziali
    @GetMapping("/{nome}")
    public ModelAndView loadByInitial(@RequestParam("nome") String nome){
        return new ModelAndView("visualizzaFotografi","fotografi", fotografoService.getFotografiStartingWith(nome));
    }
    //Aggiunta di un fotografo
    @GetMapping("/add")
    public ModelAndView showForm() {
        return new ModelAndView("formFotografo","fotografo",new Fotografo());
    }
    @PostMapping("/add")
    public ModelAndView insertFotografo(@Valid Fotografo fotografo, BindingResult bindingResult) {
        boolean emailExist = fotografoService.fotografoExistsByEmail(fotografo.getEmail());
        if (bindingResult.hasErrors() || emailExist)
            return new ModelAndView("formFotografo", "emailExist", emailExist);
        fotografoService.setAlbumAndSaveFotografo(fotografo);
        return new ModelAndView("redirect:/photographers","fotografi",fotografoService.getAllFotografi());
    }
    //Cancellazione singolo fotografo
    @GetMapping("/{id}/delete")
    public ModelAndView deletePhotographers(@PathVariable("id") Long id) {
        fotografoService.getFografoByIdAndDelete(id);
        return new ModelAndView("redirect:/photographers","fotografi", fotografoService.getAllFotografi());
    }
    //Modifica dati fotografo
    @GetMapping("/{id}/edit")
    public ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        return new ModelAndView("modificaFotografo","fotografo", fotografoService.getFotografoById(id));
    }
    @PostMapping("/{id}/update")
    public ModelAndView updateFotografo(@PathVariable("id") Long id, @Valid Fotografo fotografo, BindingResult result) {
        Fotografo fotografoVecchio = fotografoService.getFotografoById(id);
        boolean emailExist = fotografoService.existsAnotherEmail(fotografo.getEmail(),fotografoVecchio);
        if (result.hasErrors() || emailExist)
            return new ModelAndView("modificaFotografo","emailExist",emailExist);
        fotografoService.save(fotografo);
        return new ModelAndView("redirect:/photographers","fotografi", fotografoService.getAllFotografi());
    }
}