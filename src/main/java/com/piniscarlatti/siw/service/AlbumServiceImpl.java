package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album Id:" + id));
    }

    @Override
    public List<Album> getAlbumsByFotografo(Fotografo fotografo) {
        return albumRepository.findByFotografo(fotografo);
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void setFotografoAndSaveAlbum(Album album,Fotografo fotografo) {
        album.setFotografo(fotografo);
        albumRepository.save(album);
    }

    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    @Override
    public void updataNomeAlbum(Album album, String nome) {
        album.setNome(nome);
        albumRepository.save(album);
    }

    public Album trovaDaFotografoPerId(Long idFotografo, Long idAlbum){
        return albumRepository.findByFotografo_IdAndId(idFotografo, idAlbum);
    }

    public Album perId(Long id){
        return albumRepository.findById(id).get();
    }
}
