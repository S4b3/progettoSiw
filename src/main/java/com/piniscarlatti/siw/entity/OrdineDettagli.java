package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dettagliordine")
public class OrdineDettagli {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String usernameUtente;
    private String nome;
    private String cognome;
    @OneToOne
    private Ordine ordine;

    public OrdineDettagli(){

    }

}
