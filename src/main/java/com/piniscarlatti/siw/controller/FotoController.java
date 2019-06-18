package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.persistenceService.AlbumService;
import com.piniscarlatti.siw.persistenceService.FotoService;
import com.piniscarlatti.siw.persistenceService.FotografoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/photographers/{idP}/album/{idA}/photo")
public class FotoController {

    @Autowired
    FotografoService fotografoService;

    @Autowired
    AlbumService albumService;

    @Autowired
    FotoService fotoService;

    @GetMapping
    public String visualizzaFoto(@PathVariable("idP")Long idFotografo, @PathVariable("idA")Long idAlbum, Model model){
        Album album = albumService.perId(idAlbum);
        List<Foto> fotografie = fotoService.trovaFotoDaAlbum(album);
        model.addAttribute("album", fotografie);
        return "visualizzaFoto";
    }

}
