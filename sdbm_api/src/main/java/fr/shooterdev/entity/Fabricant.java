package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(name="FABRICANT")
public class Fabricant {

    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column( name = "ID_FABRICANT", nullable = false)
	private Long id;

    @NotNull
    @Column (name="NOM_FABRICANT")
    private String name;

    @OneToMany()
    private List<Marque> marques = new ArrayList<>();

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

