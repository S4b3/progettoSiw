package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Data
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Foto> fotografie;

    public double getSubTotal(){
        return fotografie.stream()
                .map(i-> i.getPrezzo()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    public void setFotografia(Foto foto){
        this.fotografie.add(foto);
    }


}
