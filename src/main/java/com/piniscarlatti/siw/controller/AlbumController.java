package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Album;
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
@RequestMapping("/photographers/{id}/album")
public class AlbumController implements WebMvcConfigurer {

    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    AlbumRepository albumRepository;


    //visualizzazione
    @GetMapping
    public String seeAlbum(@PathVariable("id") Long id, Model model) {

        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));

        model.addAttribute("albums", albumRepository.findByFotografo(fotografo));
        model.addAttribute("fotografo", fotografo);
        return "visualizzaAlbum";
    }

    //aggiunta di un album
    @GetMapping("/add")
    public String showForm(@PathVariable("id") Long id, Model model) {

        model.addAttribute("album", new Album());
        model.addAttribute("photographId", id);
        System.out.println(model.asMap().get("photographId"));

        return "aggiungiAlbum";
    }

    @PostMapping("/add")
    public RedirectView insertAlbum(@Valid Album album, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {

        Fotografo fotografo = fotografoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
        album.setFotografo(fotografo);
        albumRepository.save(album);

        List<Album> albums = new ArrayList<>(albumRepository.findAll());
        model.addAttribute("albums", albums);
        return new RedirectView("/photographers/{id}/album");
    }

    //photographers/{id}/album/{idAlbum}/delete
    @GetMapping("/{idAlbum}/delete")
    public RedirectView deletePhotographers(@PathVariable("id") Long id, @PathVariable("idAlbum") Long idAlbum, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
        Album album = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album Id:" + id));
        albumRepository.delete(album);
        model.addAttribute("albums", albumRepository.findByFotografo(fotografo));
        return new RedirectView("/photographers/{id}/album");
    }

    //Modifica nome album
    @GetMapping("/{idAlbum}/edit")
    public String showUpdateForm(  @PathVariable("idAlbum") Long idAlbum, Model model) {
        Album album = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album Id:" + idAlbum));

        model.addAttribute("album", album);
        return "modificaAlbum";
    }

    @PostMapping("/{idAlbum}/update")
    public ModelAndView updateAlbum(@PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id,@Valid Album album, BindingResult bindingResult, Model model) {
        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
        Album albumNuovo = albumRepository.findById(idAlbum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album Id:" + idAlbum));
        albumNuovo.setNome(album.getNome());
        albumRepository.save(albumNuovo);
        model.addAttribute("albums", albumRepository.findByFotografo(fotografo));
        return new ModelAndView("redirect:/photographers/{id}/album");
    }

}