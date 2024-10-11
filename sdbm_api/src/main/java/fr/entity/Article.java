package fr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Article {

    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
 	@Column(name="ID_ARTICLE")
	private Long id;
    @Column (name="NOM_ARTICLE")
    private String name;
    @Column (name="PRIX_ACHAT")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

