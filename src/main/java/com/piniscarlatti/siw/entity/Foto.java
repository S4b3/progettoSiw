package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "fotografie")
@EqualsAndHashCode
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String categoria;
    @ManyToOne
    private Album album;
    @Column(nullable = false)
    private String url;
    @ManyToMany(mappedBy = "fotografie")
    private List<Ordine> ordini;
    @ManyToMany(mappedBy = "fotografie")
    private List<Carrello> carrelli;
    private double prezzo;

    public Foto() {
    }

    public Foto(String nome, String categoria, Album album, String url, double prezzo) {
        this.nome = nome;
        this.categoria = categoria;
        this.album = album;
        this.url = url;
        this.prezzo = prezzo;

    }

    public Foto(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }
}

