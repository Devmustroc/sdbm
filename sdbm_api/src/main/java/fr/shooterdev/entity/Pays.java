package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name="PAYS")
public class Pays {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name = "ID_PAYS", nullable = false)
	private Long id;

    @NotNull
	@Column (name="NOM_PAYS")
 	private String nomPays;

    @OneToMany()
  	private List<Marque> marques = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return nomPays;
    }

    public void setName(String name) {
        this.nomPays = name;
    }

}

