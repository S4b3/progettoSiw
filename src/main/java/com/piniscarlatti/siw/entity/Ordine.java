package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ordine {

    @ManyToMany
    private List<Foto> fotografie;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "ordine")
    private OrdineDettagli dettagli;
    private int prezzo;


}