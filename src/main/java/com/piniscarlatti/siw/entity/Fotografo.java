package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "fotografo")
@Data
@EqualsAndHashCode
public class Fotografo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

    @OneToMany(mappedBy = "fotografo", cascade = CascadeType.ALL)
    @MapKey(name ="_id")
    private Map<Long, Album> album;


    public Fotografo(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.album = new HashMap<>();
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.get_id(), generale);
    }

    public Fotografo() {
    }

    public void setAlbumBase(){
        this.album = new HashMap<>();
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.get_id(), generale);
    }

}
