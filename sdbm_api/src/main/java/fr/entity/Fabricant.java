package fr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Fabricant {

    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
 	@Column(name="ID_FABRICANT")
	private Long id;
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

