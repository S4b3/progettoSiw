package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}