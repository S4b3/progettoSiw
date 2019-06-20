package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Ordine;
import com.piniscarlatti.siw.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoServiceImpl implements FotoService {

    @Autowired
    FotoRepository fotoRepository;

    public List<Foto> trovaTutteDaAlbum(Album album){
        return fotoRepository.findByAlbum(album);
    }

    public List<Foto> trovaTutteDaOrdine(List<Ordine> ordini) {
        return fotoRepository.findByOrdini(ordini);
    }

    public List<Foto> trovaTutteDaCarrelli(List<Carrello> carrelli) {
        return fotoRepository.findByCarrelli(carrelli);
    }

    public void salva(Foto foto){
        fotoRepository.save(foto);
    }

    public List<Foto> trovaTutte(){
        return fotoRepository.findAll();
    }

    public Foto perId(Long id) { return fotoRepository.findById(id).get(); }
}
