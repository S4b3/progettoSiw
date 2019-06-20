package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Fotografo;
import java.util.List;

public interface FotografoService {

    List<Fotografo> getAllFotografi();
    List<Fotografo> getFotografiStartingWith(String nome);
    Fotografo getFotografoById(Long id);
    boolean fotografoExistsByEmail(String email);
    boolean existsAnotherEmail(String email,Fotografo fotografoVecchio);
    void setAlbumAndSaveFotografo(Fotografo fotografo);
    void save(Fotografo fotografo);
    void getFografoByIdAndDelete(Long id);
    boolean ciSonoFotoInOrdini(Long id);
    boolean ciSonoFotoInCarrelli(Long id);
}
