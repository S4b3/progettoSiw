package com.piniscarlatti.siw.persistenceService;

import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotografoService implements FotografoServiceInteface {

    @Autowired
    FotografoRepository fotografoRepository;

    @Override
    public void addFotografo(Fotografo fotografo) {

        fotografoRepository.save(fotografo);

    }

    @Override
    public void deleteFotografo(Fotografo fotografo) {

        fotografoRepository.deleteById(fotografo.getId());

    }

    @Override
    public void deleteAllFotografi() {
        fotografoRepository.deleteAll();
    }

    public Fotografo perId(Long id){
        return fotografoRepository.findById(id).get();
    }
}
