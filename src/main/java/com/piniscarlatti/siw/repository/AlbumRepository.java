package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByFotografo(Fotografo fotografo);
}
