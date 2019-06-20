package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbum();
    Album getAlbumById(Long id);
    List<Album> getAlbumsByFotografo(Fotografo fotografo);
    List<Album> getAlbumsByTitolo(Fotografo fotografo,String nome);
    void save(Album album);
    void setFotografoAndSaveAlbum(Album album,Fotografo fotografo);
    void delete(Album album);
    void updataNomeAlbum(Album album,String nome);



}
