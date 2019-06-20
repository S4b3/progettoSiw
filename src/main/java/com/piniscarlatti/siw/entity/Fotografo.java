package com.piniscarlatti.siw.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity
@Table(name = "fotografo")
@Data
@EqualsAndHashCode
public class Fotografo implements Serializable,Comparable<Fotografo> {

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
    }

    public Fotografo() {
    }

    public void setAlbumBase(){
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.getId(), generale);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fotografo fotografo = (Fotografo) o;
        return Objects.equals(id, fotografo.id) &&
                Objects.equals(email, fotografo.email) &&
                Objects.equals(nome, fotografo.nome) &&
                Objects.equals(cognome, fotografo.cognome);
    }

    @Override
    public int compareTo(Fotografo that) {

        return this.getEmail().compareTo(that.getEmail());
    }

    public int getNumeroFoto(){
        return album.entrySet().stream()
                .map(i-> i.getValue().numeroFoto()).collect(Collectors.summingInt(Integer::intValue));
    }
}
