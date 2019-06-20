package com.piniscarlatti.siw.controller;


import com.piniscarlatti.siw.service.FotografoServiceImpl;
import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.service.AlbumServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String seeAlbum(@PathVariable("id") Long id, Model model) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        model.addAttribute("albums", albumService.getAlbumsByFotografo(fotografo));
        model.addAttribute("fotografo", fotografo);
        return "visualizzaAlbum";
    }
    //visualizza fotografi per iniziali
    @GetMapping("/{value}")
    public String loadByInitial(@RequestParam("value") String value,@PathVariable("id") Long id, Model model){
        model.addAttribute("albums", albumService.getAlbumsByTitolo(fotografoService.getFotografoById(id),value.toUpperCase()));
        model.addAttribute("fotografo",fotografoService.getFotografoById(id));
        return "visualizzaAlbum";
    }
    //aggiunta di un album
    @GetMapping("/add")
    public String showForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("photographId", id);
        return "aggiungiAlbum";
    }
    @PostMapping("/add")
    public String insertAlbum(@Valid Album album, @PathVariable("id") Long id,Model model) {
        albumService.setFotografoAndSaveAlbum(album, fotografoService.getFotografoById(id));
        model.addAttribute("albums", albumService.getAllAlbum());
        return "redirect:/photographers/{id}/album";
    }
    //photographers/{id}/album/{idAlbum}/delete
    @GetMapping("/{idAlbum}/delete")
    public String deletePhotographers(@PathVariable("id") Long id, @PathVariable("idAlbum") Long idAlbum,Model model) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        Album album = albumService.getAlbumById(idAlbum);
        albumService.delete(album);
        model.addAttribute( "albums", albumService.getAlbumsByFotografo(fotografo));
        return "redirect:/photographers/{id}/album";
    }

    //Modifica nome album
    @GetMapping("/{idAlbum}/edit")
    public String showUpdateForm(@PathVariable("idAlbum") Long idAlbum,Model model) {
        Album album = albumService.getAlbumById(idAlbum);
        model.addAttribute("album",album);
        return "modificaAlbum";
    }

    @PostMapping("/{idAlbum}/update")
    public String updateAlbum(@PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id,@Valid Album album, Model model) {
        Fotografo fotografo = fotografoService.getFotografoById(id);
        Album albumNuovo = albumService.getAlbumById(idAlbum);
        albumService.updataNomeAlbum(albumNuovo, album.getNome());
        model.addAttribute("albums", albumService.getAlbumsByFotografo(fotografo));
        return "redirect:/photographers/{id}/album";
    }

}