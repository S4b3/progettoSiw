package com.piniscarlatti.siw.Dao;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;

import java.util.List;

public interface AlbumDao {

    List<Album> findAll();
    Album findById(Long id);
    List<Album> findByFotografo(Fotografo fotografo);
    void save(Album album);
    void delete(Album album);


}
