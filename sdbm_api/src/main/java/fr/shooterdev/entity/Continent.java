package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity(name = "CONTINENT")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTINENT", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "NOM_CONTINENT")
    private String nomContinent;

    public String getNomContinent() {
        return nomContinent;
    }

    public void setNomContinent(String nomContinent) {
        this.nomContinent = nomContinent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}