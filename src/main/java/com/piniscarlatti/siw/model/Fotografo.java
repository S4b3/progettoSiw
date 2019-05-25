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
<<<<<<< HEAD
    private String email;
=======
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
>>>>>>> refs/remotes/origin/master
    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "fotografo")
    private Set<Album> album;

    protected Fotografo(){}

<<<<<<< HEAD
    public Fotografo (String nome, String cognome,String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email = email;
=======
    public Fotografo (String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
>>>>>>> refs/remotes/origin/master
    }


}
