package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.CarrelloRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import com.piniscarlatti.siw.service.CarrelloServiceImpl;
import com.piniscarlatti.siw.service.FotoServiceImpl;
import com.piniscarlatti.siw.service.FunzionarioService;
import com.piniscarlatti.siw.service.FunzionarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gallery")
@AllArgsConstructor
public class GalleryController implements WebMvcConfigurer {

    private FotografoRepository fotografoRepository;
    private FotoServiceImpl fotoService;
    private FunzionarioServiceImpl funzionarioService;
    private CarrelloServiceImpl carrelloService;

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

    @GetMapping("/photo/{idPhoto}")
    public String getFotoSingola(@PathVariable("idPhoto")Long id, Model model){
        model.addAttribute("fotografia", fotoService.perId(id));
        return "visualizzaSingolaFotoDettagli";
    }

    @GetMapping("/photo/buy/{idPhoto}")
    public String addFotoToOrdine(@PathVariable("idPhoto")Long id){
        Funzionario funz = funzionarioService.funzionarioCorrente();
        Long idCarrello = funz.getCarrello().getId();
        if(carrelloService.esisteFotoNelCarrello(idCarrello,fotoService.perId(id))) {
           carrelloService.salvaFotoNelCarrello(id,idCarrello);
        }
        return "redirect:/gallery";
    }

}