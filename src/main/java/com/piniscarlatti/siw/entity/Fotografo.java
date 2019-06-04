package com.piniscarlatti.siw.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String nome;
    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String cognome;

    @JsonIgnore
    @OneToMany(mappedBy = "fotografo", cascade = CascadeType.ALL)
    @MapKey(name ="id")
    private Map<Long, Album> album;

    public Fotografo(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.album = new HashMap<>();
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.getId(), generale);
    }

    public Fotografo() {
    }

    public void setAlbumBase(){
        this.album = new HashMap<>();
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.getId(), generale);
    }

}
