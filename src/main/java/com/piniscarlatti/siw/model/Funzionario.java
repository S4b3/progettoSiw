package com.piniscarlatti.siw.model;

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
<<<<<<< HEAD
    
    public Funzionario(String username, String cognome){
        this.nome=username;
        this.cognome=cognome;
=======

    public Funzionario(String username, String password){
        this.username=username;
        this.password=password;
>>>>>>> refs/remotes/origin/master
    }


}
