package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;

import java.util.List;

public interface CarrelloService {
    Carrello perId(Long id);
    void save(Carrello carrello);
    Boolean esisteFotoNelCarrello(Long id,Foto foto);
    void salvaFotoNelCarrello(Long idFoto,Long idCarrello);
    List<Foto> tutteLeFoto();
    void svuota(Long id);
    List<Carrello> tutti();
}
