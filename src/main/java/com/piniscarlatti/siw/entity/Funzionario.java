package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode
public class Funzionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    private String cognome;

    protected Funzionario(){ }

    
    public Funzionario(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;

    }

}
