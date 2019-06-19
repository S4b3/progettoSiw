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

    private String email;
    private String nome;
    private String cognome;
    @OneToOne
    private Ordine ordine;

}
