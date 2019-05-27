package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Fotografo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    @Column(unique = true)
    private String email;
    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "fotografo", cascade = CascadeType.ALL)
    private Map<Long,Album> album;


    public Fotografo (String nome, String cognome,String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.album = new HashMap<>();
        Album generale = new Album("Tutte le foto", this);
        this.album.put(generale.get_id(), generale);
    }
    protected Fotografo(){}


}
