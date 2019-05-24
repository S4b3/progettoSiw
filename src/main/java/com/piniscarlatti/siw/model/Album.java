package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    private List<Foto> fotografie;
    private Fotografo fotografo;
    
    @Override
    public boolean equals(Object o){
        Album that = (Album) o;
        if(this.nome.equals(that.getNome()) && this.fotografo.equals(that.getFotografo())) { return true; }
        return  false;
    }
}
