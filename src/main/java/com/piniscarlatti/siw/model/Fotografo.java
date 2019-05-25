package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Fotografo implements Serializable {

    @Id
    private String email;
    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "fotografo")
    private Set<Album> album;

    protected Fotografo(){}

    public Fotografo (String nome, String cognome,String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email = email;
    }


}
