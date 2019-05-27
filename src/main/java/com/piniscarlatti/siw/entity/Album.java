package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Long,Foto> fotografie;
    @ManyToOne
    private Fotografo fotografo;

    protected Album(){

    }
    public Album(String nome, Fotografo fotografo){
        this.nome=nome;
        this.fotografo = fotografo;
        this.fotografie = new HashMap<>();

    }

    @Override
    public boolean equals(Object o){
        Album that = (Album) o;
        if(this.nome.equals(that.getNome()) && this.fotografo.equals(that.getFotografo())) { return true; }
        return  false;
    }
}
