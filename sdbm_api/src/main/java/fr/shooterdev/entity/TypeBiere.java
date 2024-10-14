package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "TYPEBIERE")
public class TypeBiere {

    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
 	@Column(name = "ID_TYPE", nullable = false)
	private Long id;

    @NotNull
    @Column (name="NOM_TYPE")
    private String nomTypeBiere;

    @OneToMany()
    private List<Article> articles = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return nomTypeBiere;
    }

    public void setName(String name) {
        this.nomTypeBiere = name;
    }

}

