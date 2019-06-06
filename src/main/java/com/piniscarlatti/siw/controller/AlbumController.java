package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.Service.AlbumServiceImpl;
import com.piniscarlatti.siw.Service.FotografoServiceImpl;
import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;


@Controller
@RequestMapping("/photographers/{id}/album")
@AllArgsConstructor
public class AlbumController implements WebMvcConfigurer {

    private AlbumServiceImpl albumService;
    private FotografoServiceImpl fotografoService;

    //visualizzazione
    @GetMapping
    public ModelAndView seeAlbum(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("albums", albumService.getAlbumsByFotografo(fotografo));
        model.addAttribute("fotografo", fotografo);
        return new ModelAndView("visualizzaAlbum", model.asMap());
    }
    //aggiunta di un album
    @GetMapping("/add")
    public ModelAndView showForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("photographId", id);
        return new ModelAndView("aggiungiAlbum", model.asMap());
    }
    @PostMapping("/add")
    public ModelAndView insertAlbum(@Valid Album album, @PathVariable("id") Long id) {
        albumService.setFotografoAndSaveAlbum(album, fotografoService.getFotografoById(id));
        return new ModelAndView("redirect:/photographers/{id}/album", "albums", albumService.getAllAlbum());
    }
    //photographers/{id}/album/{idAlbum}/delete
    @GetMapping("/{idAlbum}/delete")
    public ModelAndView deletePhotographers(@PathVariable("id") Long id, @PathVariable("idAlbum") Long idAlbum) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        Album album = albumService.getAlbumById(idAlbum);
        albumService.delete(album);
        return new ModelAndView("redirect:/photographers/{id}/album", "albums", albumService.getAlbumsByFotografo(fotografo));
    }

    //Modifica nome album
    @GetMapping("/{idAlbum}/edit")
    public ModelAndView showUpdateForm(@PathVariable("idAlbum") Long idAlbum) {
        Album album = albumService.getAlbumById(idAlbum);
        return new ModelAndView("modificaAlbum", "album", album);
    }

    @PostMapping("/{idAlbum}/update")
    public ModelAndView updateAlbum(@PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id,@Valid Album album) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        Album albumNuovo = albumService.getAlbumById(idAlbum);
        albumService.updataNomeAlbum(albumNuovo, album.getNome());
        return new ModelAndView("redirect:/photographers/{id}/album", "albums", albumService.getAlbumsByFotografo(fotografo));
    }

}