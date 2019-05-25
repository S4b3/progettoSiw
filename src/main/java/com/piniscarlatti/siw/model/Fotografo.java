package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Fotografo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "fotografo")
    private Set<Album> album;

    protected Fotografo(){}

    public Fotografo (String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
    }


}
