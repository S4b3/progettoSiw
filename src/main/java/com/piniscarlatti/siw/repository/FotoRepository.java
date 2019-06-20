package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Carrello;
import com.piniscarlatti.siw.entity.Foto;
import com.piniscarlatti.siw.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    List<Foto> findByAlbum(Album album);
    List<Foto> findByOrdini(List<Ordine> ordini);
    List<Foto> findByCarrelli(List<Carrello> carrelli);
}
