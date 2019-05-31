package com.piniscarlatti.siw.persistenceService;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;

public interface AlbumServiceInterface {

    void addAlbum(Album album);
    void deleteAlbum(Album album);
    void deleteAllAlbum();
    void deleteAlbumDelFotografo(Fotografo fotografo);

}
