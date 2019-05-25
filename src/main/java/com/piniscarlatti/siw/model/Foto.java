package com.piniscarlatti.siw.model;

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
    private Fotografo fotografo;

    protected Foto(){}

    private Foto(String nome, String categoria){
        this.nome=nome;
        this.categoria=categoria;
    }
}
