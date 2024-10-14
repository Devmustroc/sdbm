package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "ARTICLE")
public class Article {

    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name = "ID_ARTICLE", nullable = false)
	private Long id;

    @NotNull
    @Column (name = "NOM_ARTICLE")
    private String nomArticle;

    @Column (name = "PRIX_ACHAT")
    private float prixAchat;

    @Column (name = "VOLUME")
    private int volume;

    @Column (name = "TITRAGE")
    private float titrage;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String name) {
        this.nomArticle = name;
    }

    public float getPrixAchatArticle() {
        return prixAchat;
    }

    public void setNomArticle(float prix) {
        this.prixAchat = prix;
    }
        
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getTitrage() {
        return titrage;
    }

    public void setTitrage(float titrage) {
        this.titrage = titrage;
    }
}

