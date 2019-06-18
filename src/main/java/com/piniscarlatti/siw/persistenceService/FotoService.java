package com.piniscarlatti.siw.persistenceService;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FotoService implements FotoServiceInterface{

    @Autowired
    FotoRepository fotoRepository;

    @Override
    public void addFoto(Foto foto) {
        fotoRepository.save(foto);
    }

    public List<Foto> trovaFotoDaAlbum(Album album){
        return fotoRepository.findByAlbum(album);
    }

    @Override
    public void deleteFoto(Foto foto) {
        fotoRepository.deleteById(foto.getId());
    }

    @Override
    public void deleteAllFoto() {
        fotoRepository.deleteAll();
    }

    @Override
    public void deleFotoAlbum(Album album) {

        List<Foto> fotoDaEliminare = new ArrayList<>();
        List<Foto> fotos = fotoRepository.findAll();
        fotos.parallelStream()
                .filter(i -> i.getAlbum().getId() == album.getId())
                .map(i -> fotoDaEliminare.add(i));
    }

}
