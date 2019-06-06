package com.piniscarlatti.siw.Dao;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album Id:" + id));
    }

    @Override
    public List<Album> findByFotografo(Fotografo fotografo) {
        return albumRepository.findByFotografo(fotografo);
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }
}
