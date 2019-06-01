package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class Funzionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

    protected Funzionario() {
    }


    public Funzionario(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;

    }

}
