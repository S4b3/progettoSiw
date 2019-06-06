package com.piniscarlatti.siw.Dao;

import com.piniscarlatti.siw.entity.Fotografo;

import java.util.List;

public interface FotografoDao {

    List<Fotografo> findAll();
    boolean existsByEmail(String email);
    boolean existsAnotherEmail(String email,Fotografo fotografoVecchio);
    Fotografo findById(Long id);
    void save(Fotografo fotografo);
    void delete(Fotografo fotografo);
    List<Fotografo> findByNomeStartingWith(String nome);

}
