package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "TYPEBIERE")
public class TypeBiereEntity {

    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
 	@Column(name = "ID_TYPE", nullable = false)
	private Long id;

    @NotNull
    @Column (name="NOM_TYPE")
    private String nomTypeBiere;

    @OneToMany()
    private List<ArticleEntity> articles = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomTypeBiere() {
        return nomTypeBiere;
    }

    public void setNomTypeBiere(String nomTypeBiere) {
        this.nomTypeBiere = nomTypeBiere;
    }

}

