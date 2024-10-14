package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="MARQUE")
public class MarqueEntity {

    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name = "ID_MARQUE", nullable = false)
	private Long id;

    @NotNull
    @Column (name = "NOM_MARQUE")
    private String nomMarque;

    @OneToMany()
    private List<ArticleEntity> articles = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

}

