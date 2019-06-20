package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;

import java.util.List;

public interface FotoService {

     List<Foto> trovaTutteDaAlbum(Album album);

     void salva(Foto foto);

     List<Foto> trovaTutte();

     Foto perId(Long id);
}
