package com.piniscarlatti.siw.persistenceService;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService implements AlbumServiceInterface {

    @Autowired
    AlbumRepository albumRepository;
    @Override
    public void addAlbum(Album album) {

        albumRepository.save(album);

    }

    @Override
    public void deleteAlbum(Album album) {

        albumRepository.deleteById(album.get_id());

    }

    @Override
    public void deleteAllAlbum() {

        albumRepository.deleteAll();

    }

    @Override
    public void deleteAlbumDelFotografo(Fotografo fotografo) {

        List<Album> albumDaEliminare = new ArrayList<>();
        List<Album> albums = albumRepository.findAll();
        albums.parallelStream()
                .filter(i-> i.getFotografo().get_id()==fotografo.get_id())
                .map(i-> albumDaEliminare.add(i));

    }
}
