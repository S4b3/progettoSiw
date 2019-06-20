package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ordine {

    @ManyToMany
    private List<Foto> fotografie;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double prezzo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String usernameUtente;

    public Ordine(){
        this.fotografie = new ArrayList<>();
    }

    public Ordine(List<Foto> fotografie, double prezzo, String email, String usernameUtente) {
        this.fotografie = fotografie;
        this.prezzo = prezzo;
        this.email = email;
        this.usernameUtente = usernameUtente;
    }

    public void setFotografia(Foto foto){
        this.fotografie.add(foto);
    }

}
