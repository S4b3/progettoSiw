package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Ordine;
import com.piniscarlatti.siw.repository.OrdiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdiniService {

    @Autowired
    OrdiniRepository ordiniRepository;

    public List<Ordine> getAll(){
        List<Ordine> ordini = ordiniRepository.findAll();
        return ordini;
    }

    public Ordine perId(Long id){
        return ordiniRepository.findById(id).get();
    }

    public List<Foto> getFotoOrdine(Long id){
        Ordine o = ordiniRepository.findById(id).get();
        return o.getFotografie();
    }

    public void salva(Ordine o){
        this.ordiniRepository.save(o);
    }


}
