package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    public List<Album> findByFotografo(Fotografo fotografo);

    public Album findByFotografo_IdAndId(Long idFotografo, Long idAlbum);
}
