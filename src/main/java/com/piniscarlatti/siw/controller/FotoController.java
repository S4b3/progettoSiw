package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.service.AlbumServiceImpl;
import com.piniscarlatti.siw.service.FotoServiceImpl;
import com.piniscarlatti.siw.service.FotografoService;
import com.piniscarlatti.siw.service.ImageStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/photographers/{idP}/album/{idA}/photo")
@AllArgsConstructor
public class FotoController {

    FotografoService fotografoService;
    AlbumServiceImpl albumService;
    FotoServiceImpl fotoService;
    ImageStorageService imgStorage;

    @GetMapping("")
    public String visualizzaFotoAlbum(@PathVariable("idP")Long idP, @PathVariable("idA")Long idAlbum, Model model){

        Album album = albumService.perId(idAlbum);
        List<Foto> fotografie = fotoService.trovaTutteDaAlbum(album);
        model.addAttribute("fotografo", fotografoService.getFotografoById(idP));
        model.addAttribute("album", album);
        model.addAttribute("fotografie", fotografie);
        return "visualizzaFoto";
    }

}
