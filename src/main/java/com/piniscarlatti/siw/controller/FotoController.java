package com.piniscarlatti.siw.controller;
import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/photographers/{idP}/album/{idA}/photo")
@AllArgsConstructor
public class FotoController {

    FotografoService fotografoService;
    AlbumServiceImpl albumService;
    FotoServiceImpl fotoService;
    ImageStorageService imgStorage;

    @GetMapping
    public String visualizzaFotoAlbum(@PathVariable("idP")Long idP, @PathVariable("idA")Long idAlbum, Model model){

        Album album = albumService.perId(idAlbum);
        List<Foto> fotografie = fotoService.trovaTutteDaAlbum(album);
        model.addAttribute("fotografo", fotografoService.getFotografoById(idP));
        model.addAttribute("album", album);
        model.addAttribute("fotografie", fotografie);
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
        fotoService.salva(foto);
        return "redirect:/photographers/{idP}/album/{idA}/photo";
    }
}
