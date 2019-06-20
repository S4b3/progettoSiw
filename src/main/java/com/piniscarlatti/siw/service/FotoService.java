package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Ordine;

import java.util.List;

public interface FotoService {

     List<Foto> trovaTutteDaAlbum(Album album);

     List<Foto> trovaTutteDaOrdine(List<Ordine> ordini);

     List<Foto> trovaTutteDaCarrelli(List<Carrello> carrelli);

     void salva(Foto foto);

     List<Foto> trovaTutte();

     Foto perId(Long id);
}
