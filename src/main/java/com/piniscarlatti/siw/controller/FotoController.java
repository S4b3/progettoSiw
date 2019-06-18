package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.Service.AlbumService;
import com.piniscarlatti.siw.Service.FotografoService;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.repository.FotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/photographers/{idP}/album/{idA}/photo")
@AllArgsConstructor
public class FotoController {

    private FotoRepository fotoRepository;
    private FotografoService fotografoService;
    private AlbumService albumService;
    private com.piniscarlatti.siw.service.ImageStorageService imgStorage;

    @GetMapping
    public String visualizzaFoto(@PathVariable("idP")Long idp, @PathVariable("idA")Long idA, Model model){
        model.addAttribute("album",albumService.getAlbumById(idA));
        model.addAttribute("fotografo",fotografoService.getFotografoById(idp));
        model.addAttribute("fotografie",fotoRepository.findAll());
        return "visualizzaFoto";
    }

    @GetMapping("/addfoto")
    public String addfoto(@PathVariable("idP")Long idp, @PathVariable("idA")Long idA,Model model){
        model.addAttribute("album",albumService.getAlbumById(idA));
        model.addAttribute("fotografo",fotografoService.getFotografoById(idp));
        model.addAttribute("foto",new Foto());
        return "addfoto";
    }

    @PostMapping
    public String submit(@PathVariable("idP")Long idp, @PathVariable("idA")Long idA,@RequestParam("file") MultipartFile file,@Valid Foto foto){
        String url = imgStorage.storeImage(file);
        foto.setAlbum(albumService.getAlbumById(idA));
        foto.setUrl(url);
        foto.setNome("prova");
        fotoRepository.save(foto);
        return "redirect:/photographers/{idP}/album/{idA}/photo";
    }
}
