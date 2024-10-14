package fr.shooterdev.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "CONTINENT")
public class ContinentEntity {

    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name="ID_CONTINENT", nullable = false)
    private int id;

    @Column (name="NOM_CONTINENT")
    private String name;

    @OneToMany()
    private List<PaysEntity> pays = new ArrayList<>();

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNomContinent() {
        return name;
    }

    public void setNomContinent(String name) {
        this.name = name;
    }

    }

