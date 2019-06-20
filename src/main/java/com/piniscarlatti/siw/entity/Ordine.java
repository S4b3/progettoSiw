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
    @OneToOne
    private OrdineDettagli dettagli;
    private double prezzo;

    public Ordine(OrdineDettagli odett, double prezzo, List<Foto> fotografie){
        this.dettagli = odett;
        this.prezzo = prezzo;
        this.fotografie = fotografie;
    }

}
