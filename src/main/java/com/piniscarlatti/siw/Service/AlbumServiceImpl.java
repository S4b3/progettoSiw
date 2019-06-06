package com.piniscarlatti.siw.Service;

import com.piniscarlatti.siw.Dao.AlbumDaoImpl;
import com.piniscarlatti.siw.entity.Album;
import com.piniscarlatti.siw.entity.Fotografo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDaoImpl albumDao;

    @Override
    public List<Album> getAllAlbum() {
        return albumDao.findAll();
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumDao.findById(id);
    }

    @Override
    public List<Album> getAlbumsByFotografo(Fotografo fotografo) {
        return albumDao.findByFotografo(fotografo);
    }

    @Override
    public void save(Album album) {
        albumDao.save(album);
    }

    @Override
    public void setFotografoAndSaveAlbum(Album album,Fotografo fotografo) {
        album.setFotografo(fotografo);
        albumDao.save(album);
    }

    @Override
    public void delete(Album album) {
        albumDao.delete(album);
    }

    @Override
    public void updataNomeAlbum(Album album, String nome) {
        album.setNome(nome);
        albumDao.save(album);
    }
}
