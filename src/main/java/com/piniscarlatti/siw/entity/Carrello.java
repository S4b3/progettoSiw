package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Data
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Foto> fotografie;

    @OneToOne
    private Funzionario funzionario;

    private double subTotolal;

    public double getSubTotal(){
        return fotografie.stream()
                .map(i-> i.getPrezzo()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    public void setFotografia(Foto foto){
        this.fotografie.add(foto);
    }
}
