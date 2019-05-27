package com.piniscarlatti.siw.model;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import com.piniscarlatti.siw.repository.FotoRepository;
import com.piniscarlatti.siw.repository.FotografoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Data
public class Galleria {

    @Autowired
    FotografoRepository fotografoRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    FotoRepository fotoRepository;

    private Map<Long, Fotografo> fotografi;
    private Map<Long, Album> album;
    private Map<Long, Foto> fotografie;

    public Galleria(){
        this.fotografi = new HashMap<>();
        this.album = new HashMap<>();
        this.fotografie = new HashMap<>();
    }

    public void aggiungiFotografo(Fotografo fotografo){
        this.fotografi.put(fotografo.get_id(),fotografo);
        fotografoRepository.save(fotografo);
    }

    public void aggiungiAlbum(Album album){
        this.album.put(album.get_id(),album);
        albumRepository.save(album);

    }

    public void aggiungiFotografia(Foto foto){
        this.fotografie.put(foto.get_id(),foto);
        fotoRepository.save(foto);
    }

}
