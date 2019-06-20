package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.*;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PreUpdate;
import javax.validation.Valid;
import java.io.Console;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProjectController {

    FunzionarioServiceImpl funzionarioService;
    FunzionarioRepository fr;
    PasswordEncoder pwd;
    CarrelloServiceImpl carrelloService;
    OrdiniService ordiniService;
    FotoServiceImpl fotoService;

    @GetMapping("/")
    public String getIndex(){
        return "home";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/carrello")
    public String Carrello(Model model){
        Carrello carrello = funzionarioService.funzionarioCorrente().getCarrello();
        model.addAttribute("dettagliOrdine", new Ordine());
        model.addAttribute("utente", funzionarioService.funzionarioCorrente());
        model.addAttribute("fotografie",carrelloService.tutteLeFoto());
        model.addAttribute("carrello",carrello);
        model.addAttribute("totale", carrello.getSubTotal());
        return "carrello";
    }

    @PostMapping("/orderConfirm/{idCarrello}")
    public String confermaOrdine(@Valid Ordine ordine, @PathVariable("idCarrello")Long idCarrello){
        Carrello carrello = this.carrelloService.perId(idCarrello);
        ordine.setUsernameUtente(this.funzionarioService.funzionarioCorrente().getUsername());
        ordine.setPrezzo(carrello.getSubTotal());
        for(Foto f:fotoService.trovaTutte()){
            ordine.setFotografia(fotoService.perId(f.getId()));
        }
        carrelloService.svuota(idCarrello);
        ordiniService.salva(ordine);
        return "redirect:/gallery";
    }

    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal)
    {
        return principal;
    }


}
