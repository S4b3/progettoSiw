package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "album_id")
    private List<Foto> fotografie;
    @ManyToOne
    private Fotografo fotografo;

    protected Album(){}

    private Album(String nome){

        this.nome=nome;
    }
    
    @Override
    public boolean equals(Object o){
        Album that = (Album) o;
        if(this.nome.equals(that.getNome()) && this.fotografo.equals(that.getFotografo())) { return true; }
        return  false;
    }
}
