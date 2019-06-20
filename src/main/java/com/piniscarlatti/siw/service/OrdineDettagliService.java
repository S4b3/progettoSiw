package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.OrdineDettagli;
import com.piniscarlatti.siw.repository.OrdineDettagliRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdineDettagliService implements OrdineDettagliServiceInterface {

    OrdineDettagliRepository ordineDettagliRepository;

    @Override
    public void salva(OrdineDettagli o){
        ordineDettagliRepository.save(o);
    }

}
