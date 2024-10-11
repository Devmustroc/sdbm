package fr.shooterdev.entity;

import jakarta.persistence.*;
import java.util.ListArray;

@Entity
public class Continent {

      @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
 	@Column(name="ID_CONTINENT");
	private Long id;
      @Column (name="NOM_CONTINENT");
      private String name;
      @OneToMany()
      private List<Pays> pays = new ArrayList<>();

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

