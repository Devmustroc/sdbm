package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="MARQUE")
public class Marque {

    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name = "ID_MARQUE", nullable = false)
	private Long id;

    @NotNull
    @Column (name = "NOM_MARQUE")
    private String name;

    @OneToMany()
    private List<Article> articles = new ArrayList<>();

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

