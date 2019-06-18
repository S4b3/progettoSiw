package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    List<Foto> findByAlbum(Album album);
}
