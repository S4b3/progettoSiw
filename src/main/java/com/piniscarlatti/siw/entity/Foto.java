package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    private String categoria;
    @OneToOne
    private Album album;

    protected Foto(){}

    public Foto(String nome, String categoria,Album album){
        this.nome = nome;
        this.categoria = categoria;
        this.album = album;
    }
}
