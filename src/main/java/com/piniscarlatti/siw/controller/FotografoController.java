package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.service.FotografoServiceImpl;
import com.piniscarlatti.siw.entity.Fotografo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
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
    @GetMapping("/{nome}")
    public String loadByInitial(@RequestParam("nome") String nome,Model model){
        model.addAttribute("fotografi", fotografoService.getFotografiStartingWith(nome.toUpperCase()));
        return "visualizzaFotografi";
    }
    //Aggiunta di un fotografo
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("fotografo",new Fotografo());
        return "formFotografo";
    }
    @PostMapping("/add")
    public String insertFotografo(@Valid Fotografo fotografo, BindingResult bindingResult,Model model) {
        boolean emailExist = fotografoService.fotografoExistsByEmail(fotografo.getEmail());
        if (bindingResult.hasErrors() || emailExist){
            model.addAttribute( "emailExist", emailExist);
            return "formFotografo";
        }
        fotografoService.setAlbumAndSaveFotografo(fotografo);
        Long id = fotografo.getId();
        return "redirect:/photographers/"+id+"/confirm";
    }
    //schermata di conferma
    @GetMapping("/{id}/confirm")
    public String confirm(@PathVariable("id")Long id,Model model){
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("fotografo",fotografo);
        return "confermaFotografo";
    }

    //Cancellazione singolo fotografo
    @GetMapping("/{id}/delete")
    public String deletePhotographers(@PathVariable("id") Long id,Model model) {
        fotografoService.getFografoByIdAndDelete(id);
        model.addAttribute("fotografi", fotografoService.getAllFotografi());
        return "redirect:/photographers";
    }
    //Modifica dati fotografo
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") Long id,Model model) {
        model.addAttribute("fotografo", fotografoService.getFotografoById(id));
        return "modificaFotografo";
    }
    @PostMapping("/{id}/update")
    public String updateFotografo(@PathVariable("id") Long id, @Valid Fotografo fotografo, BindingResult result, Model model) {
        Fotografo fotografoVecchio = fotografoService.getFotografoById(id);
        boolean emailExist = fotografoService.existsAnotherEmail(fotografo.getEmail(),fotografoVecchio);
        if (result.hasErrors() || emailExist) {
            model.addAttribute("emailExist", emailExist);
            return "modificaFotografo";
        }
        fotografoService.save(fotografo);
        return "redirect:/photographers/"+id+"/confirm";
    }
    @GetMapping("/{id}/details")
    public String showDetails(@PathVariable("id")Long id,Model model){
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("fotografo",fotografo);
        return "dettagliFotografo";
    }

}