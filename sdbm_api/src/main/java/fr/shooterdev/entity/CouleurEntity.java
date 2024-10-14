package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity(name = "COULEUR")
public class CouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COULEUR", nullable = false)
    private int id;

    @Size(max = 25)
    @NotNull
    @Column(name = "NOM_COULEUR", nullable = false, length = 25)
    private String nomCouleur;

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
