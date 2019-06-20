package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.*;
import com.piniscarlatti.siw.repository.FotografoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FotografoServiceImpl implements FotografoService {

    FotografoRepository fotografoRepository;
    AlbumServiceImpl albumService;
    OrdiniService ordiniService;
    FotoService fotoService;
    CarrelloServiceImpl carrelloService;

    @Override
    public List<Fotografo> getAllFotografi() {
        return fotografoRepository.findAll();
    }

    @Override
    public List<Fotografo> getFotografiStartingWith(String nome) {
        return fotografoRepository.findByNomeContainsOrCognomeContainsOrEmailContains(nome,nome,nome);
    }

    @Override
    public Fotografo getFotografoById(Long id) {
        return fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
    }

    @Override
    public boolean fotografoExistsByEmail(String email) {
        return fotografoRepository.existsByEmail(email);
    }

    @Override
    public boolean existsAnotherEmail(String email, Fotografo fotografoVecchio) {
        return (fotografoRepository.existsByEmail(email)) && !fotografoVecchio.getEmail().equals(email);
    }

    @Override
    public void setAlbumAndSaveFotografo(Fotografo fotografo) {
        fotografo.setNome(fotografo.getNome().toUpperCase());
        fotografo.setCognome(fotografo.getCognome().toUpperCase());
        fotografo.setEmail(fotografo.getEmail().toUpperCase());
        fotografoRepository.save(fotografo);
    }

    @Override
    public void save(Fotografo fotografo) {
        fotografo.setNome(fotografo.getNome().toUpperCase());
        fotografo.setCognome(fotografo.getCognome().toUpperCase());
        fotografo.setEmail(fotografo.getEmail().toUpperCase());
        fotografoRepository.save(fotografo);
    }

    @Override
    public void getFografoByIdAndDelete(Long id) {
        Fotografo fotografo = getFotografoById(id);
        fotografoRepository.delete(fotografo);
    }

    public boolean ciSonoFotoAlbumInOrdini(Long id, Long idAlbum){
        List<Ordine> ordini = ordiniService.tutti();
        List<Album> albums = new ArrayList<>();
        albums.add(albumService.getAlbumById(idAlbum));
        List<Foto> fotoDelFotografo = new ArrayList<>();
        //fotoDelFotografo = albums.stream().map(i -> fotoService.trovaTutteDaAlbum(albumService.getAlbumById(i.getId()))).collect(Collectors.toList());
        for(Album a:albums){
            fotoDelFotografo.addAll(fotoService.trovaTutteDaAlbum(albumService.perId(a.getId())));
        }
        List<Foto> fotoDegliOrdini = new ArrayList<>(fotoService.trovaTutteDaOrdine(ordini));
        for(Foto f: fotoDelFotografo){
            if(fotoDegliOrdini.contains(fotoService.perId(f.getId()))){
                return true;
            }
        }

        return false;
    }

    public boolean ciSonoFotoAlbumInCarrelli(Long id, Long idAlbum){
        List<Carrello> carrelli = carrelloService.tutti();
        List<Foto> tutteLeFotoNeiCarrelli = new ArrayList<>();
        for(Carrello c : carrelli){
            tutteLeFotoNeiCarrelli.addAll(c.getFotografie());
        }
        List<Foto> tutteLeFotoNelleOrdinazioni = new ArrayList<>();
        for(Ordine o : ordiniService.tutti()){
            tutteLeFotoNelleOrdinazioni.addAll(o.getFotografie());
        }
        for(Foto f : albumService.getAlbumById(idAlbum).getFotografie().values()){
            if(tutteLeFotoNeiCarrelli.contains(f) || tutteLeFotoNelleOrdinazioni.contains(f)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ciSonoFotoInOrdini(Long id) {
        List<Ordine> ordini = ordiniService.tutti();
        List<Album> albums = albumService.getAlbumsByFotografo(this.getFotografoById(id));
        List<Foto> fotoDelFotografo = new ArrayList<>();
        //fotoDelFotografo = albums.stream().map(i -> fotoService.trovaTutteDaAlbum(albumService.getAlbumById(i.getId()))).collect(Collectors.toList());
        for(Album a:albums){
            fotoDelFotografo.addAll(fotoService.trovaTutteDaAlbum(albumService.perId(a.getId())));
        }
        List<Foto> fotoDegliOrdini = new ArrayList<>(fotoService.trovaTutteDaOrdine(ordini));
        for(Foto f: fotoDelFotografo){
            if(fotoDegliOrdini.contains(fotoService.perId(f.getId()))){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean ciSonoFotoInCarrelli(Long id){
        List<Carrello> carrelli = carrelloService.tutti();
        List<Foto> tutteLeFotoNeiCarrelli = new ArrayList<>();
        for(Carrello c : carrelli){
            tutteLeFotoNeiCarrelli.addAll(c.getFotografie());
        }
        List<Foto> tutteLeFotoNelleOrdinazioni = new ArrayList<>();
        for(Ordine o : ordiniService.tutti()){
            tutteLeFotoNelleOrdinazioni.addAll(o.getFotografie());
        }
        List<Foto> tutteLeFotoNegliAlbumDelFotografo = new ArrayList<>();
        for(Album a : albumService.getAlbumsByFotografo(this.getFotografoById(id))){
            tutteLeFotoNegliAlbumDelFotografo.addAll(a.getFotografie().values());
        }
        for(Foto f : tutteLeFotoNegliAlbumDelFotografo){
            if(tutteLeFotoNeiCarrelli.contains(f) || tutteLeFotoNelleOrdinazioni.contains(f)){
                return true;
            }
        }
        return false;
    }

}
