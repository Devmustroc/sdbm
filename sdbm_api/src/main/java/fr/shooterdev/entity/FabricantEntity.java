package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "FABRICANT")
public class FabricantEntity
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column( name = "ID_FABRICANT", nullable = false)
    private Long id;

    @NotNull
    @Column (name = "NOM_FABRICANT")
    private String nomFabricant;

    @OneToMany()
    private List<MarqueEntity> marques = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomFabricant() {
        return nomFabricant;
    }

    public void setNomFabricant(String name) {
        this.nomFabricant = name;
    }

}

