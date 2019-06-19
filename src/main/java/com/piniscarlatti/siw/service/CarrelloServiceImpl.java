package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.repository.CarrelloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarrelloServiceImpl implements CarrelloService{

    private CarrelloRepository carrelloRepository;

    @Override
    public Carrello perId(Long id) {
       return this.carrelloRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
    }

    @Override
    public void save(Carrello carrello) {
        this.carrelloRepository.save(carrello);
    }

    @Override
    public Boolean esisteFotoNelCarrello(Long id,Foto foto) {
        return this.perId(id).getFotografie().contains(foto);

    }

}
