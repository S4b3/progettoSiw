package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.service.AlbumServiceImpl;
import com.piniscarlatti.siw.service.FotoServiceImpl;
import com.piniscarlatti.siw.service.FotografoService;
import com.piniscarlatti.siw.service.ImageStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/photographers/{idP}/album/{idA}/photo")
@AllArgsConstructor
public class FunzionarioFotoController {

    FotografoService fotografoService;
    AlbumServiceImpl albumService;
    FotoServiceImpl fotoService;
    ImageStorageService imgStorage;

    @GetMapping("/addfoto")
    public String addfoto(@PathVariable("idP") Long idp, @PathVariable("idA") Long idA, Model model) {
        model.addAttribute("album", albumService.getAlbumById(idA));
        model.addAttribute("fotografo", fotografoService.getFotografoById(idp));
        model.addAttribute("foto", new Foto());
        return "addfoto";
    }

    @PostMapping("")
    public String submit(@PathVariable("idA") Long idA,
                         @RequestParam("file") MultipartFile file,
                         @Valid Foto foto) {
        String url = imgStorage.storeImage(file);
        foto.setAlbum(albumService.getAlbumById(idA));
        foto.setUrl(url);
        fotoService.salva(foto);
        return "redirect:/photographers/{idP}/album/{idA}/photo";
    }

}
