package com.piniscarlatti.siw.persistenceService;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;

public interface FotoServiceInterface {

    void addFoto(Foto foto);
    void deleteFoto(Foto foto);
    void deleteAllFoto();
    void deleFotoAlbum(Album album);

}
