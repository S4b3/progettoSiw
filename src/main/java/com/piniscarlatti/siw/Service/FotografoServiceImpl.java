package com.piniscarlatti.siw.Service;

import com.piniscarlatti.siw.Dao.FotografoDaoImpl;
import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class FotografoServiceImpl implements FotografoService {

    @Autowired
    FotografoDaoImpl fotografoDao;

    @Override
    public List<Fotografo> getAllFotografi() {
        return fotografoDao.findAll();
    }

    @Override
    public List<Fotografo> getFotografiStartingWith(String nome) {

        return fotografoDao.findByNomeStartingWith(nome);
    }

    @Override
    public Fotografo getFotografoById(Long id) {
        return fotografoDao.findById(id);
    }

    @Override
    public boolean fotografoExistsByEmail(String email) {
        return fotografoDao.existsByEmail(email);
    }

    @Override
    public boolean existsAnotherEmail(String email, Fotografo fotografoVecchio) {
        return fotografoDao.existsAnotherEmail(email,fotografoVecchio);
    }

    @Override
    public void setAlbumAndSaveFotografo(Fotografo fotografo) {
        fotografo.setAlbumBase();
        fotografoDao.save(fotografo);
    }

    @Override
    public void save(Fotografo fotografo) {
        fotografoDao.save(fotografo);
    }

    @Override
    public void getFografoByIdAndDelete(Long id) {
        Fotografo fotografo = fotografoDao.findById(id);
        fotografoDao.delete(fotografo);
    }
}
