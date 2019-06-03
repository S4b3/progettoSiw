package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import lombok.AllArgsConstructor;
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
@RequestMapping("/gallery/album")
public class AlbumController implements WebMvcConfigurer {

    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    AlbumRepository albumRepository;

    //aggiunta di un album
    @GetMapping("/add/{id}")
    public String showForm(Album album, @PathVariable("id") Long id,Model model) {
        return "formAlbum";
    }

    @PostMapping("/add/{id}")
    public RedirectView insertAlbum(@Valid Album album,@PathVariable("id")  Long id, BindingResult bindingResult, Model model) {

        try {
            Fotografo fotografo = fotografoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
            album.setFotografo(fotografo);
            albumRepository.save(album);

        } catch (Exception e) {

            return new RedirectView("/gallery/album/add/{id}");
        }

        List<Album> albums = new ArrayList<>(albumRepository.findAll());
        model.addAttribute("albums", albums);
        return new RedirectView("/gallery/album/{id}");
    }

    //aggiunta album
    @GetMapping("/{id}")
    public String addAlbum(@PathVariable("id") Long id, Model model) {

        Fotografo fotografo = fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));

        model.addAttribute("albums", albumRepository.findByFotografo(fotografo));
        return "visualizzaAlbum";
    }

}