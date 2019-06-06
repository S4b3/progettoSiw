package com.piniscarlatti.siw.Dao;

import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FotografoDaoImpl implements FotografoDao {

    @Autowired
    FotografoRepository fotografoRepository;

    @Override
    public List<Fotografo> findAll() {
        return fotografoRepository.findAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return fotografoRepository.existsByEmail(email);
    }

    @Override
    public boolean existsAnotherEmail(String email,Fotografo fotografoVecchio) {
        return (fotografoRepository.existsByEmail(email)) && !fotografoVecchio.getEmail().equals(email);
    }

    @Override
    public Fotografo findById(Long id) {
        return fotografoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
    }

    @Override
    public void save(Fotografo fotografo) {
        fotografoRepository.save(fotografo);
    }

    @Override
    public void delete(Fotografo fotografo) {
        fotografoRepository.delete(fotografo);
    }

    @Override
    public List<Fotografo> findByNomeStartingWith(String nome) {
        return fotografoRepository.findByNomeStartingWith(nome);
    }


}
