package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "CONTINENT")
@Getter
@Setter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTINENT", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "NOM_CONTINENT")
    private String nomContinent;
}