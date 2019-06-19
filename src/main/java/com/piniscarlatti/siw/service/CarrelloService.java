package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;

public interface CarrelloService {
    Carrello perId(Long id);
    void save(Carrello carrello);
    Boolean esisteFotoNelCarrello(Long id,Foto foto);
}
