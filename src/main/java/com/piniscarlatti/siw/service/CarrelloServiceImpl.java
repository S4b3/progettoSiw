package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.repository.CarrelloRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarrelloServiceImpl implements CarrelloService{

    private CarrelloRepository carrelloRepository;
    private FotoServiceImpl fotoService;

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

    @Override
    public void salvaFotoNelCarrello(Long idFoto, Long idCarrello) {
        Carrello carrello = this.perId(idCarrello);
        carrello.setFotografia(fotoService.perId(idFoto));
        this.save(carrello);
    }

    @Override
    public List<Foto> tutteLeFoto() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idCarrello = ((FunzionarioDetails)principal).getCarrello().getId();
        Carrello carrello = this.perId(idCarrello);
        return carrello.getFotografie();
    }

    @Override
    public void svuota(Long id) {
        List<Foto> fotos = new ArrayList<>(this.tutteLeFoto());
        Carrello carrello = this.perId(id);
        carrello.getFotografie().removeAll(fotos);
    }

    @Override
    public List<Carrello> tutti() {
        return carrelloRepository.findAll();
    }


}
