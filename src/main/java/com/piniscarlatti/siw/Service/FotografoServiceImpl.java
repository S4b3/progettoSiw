package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.piniscarlatti.siw.service.*;

import java.util.List;

@Service
@AllArgsConstructor
public class FotografoServiceImpl implements FotografoService {

    FotografoRepository fotografoRepository;

    @Override
    public List<Fotografo> getAllFotografi() {
        return fotografoRepository.findAll();
    }

    @Override
    public List<Fotografo> getFotografiStartingWith(String nome) {
        return fotografoRepository.findByNomeContainsOrCognomeContainsOrEmailContains(nome,nome,nome);
    }

    @Override
    public Fotografo getFotografoById(Long id) {
        return fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
    }

    @Override
    public boolean fotografoExistsByEmail(String email) {
        return fotografoRepository.existsByEmail(email);
    }

    @Override
    public boolean existsAnotherEmail(String email, Fotografo fotografoVecchio) {
        return (fotografoRepository.existsByEmail(email)) && !fotografoVecchio.getEmail().equals(email);
    }

    @Override
    public void setAlbumAndSaveFotografo(Fotografo fotografo) {
        fotografo.setAlbumBase();
        fotografo.setNome(fotografo.getNome().toUpperCase());
        fotografo.setCognome(fotografo.getCognome().toUpperCase());
        fotografo.setEmail(fotografo.getEmail().toUpperCase());
        fotografoRepository.save(fotografo);
    }

    @Override
    public void save(Fotografo fotografo) {
        fotografoRepository.save(fotografo);
    }

    @Override
    public void getFografoByIdAndDelete(Long id) {
        Fotografo fotografo = getFotografoById(id);
        fotografoRepository.delete(fotografo);
    }
}
