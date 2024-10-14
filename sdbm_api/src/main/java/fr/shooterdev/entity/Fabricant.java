package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "FABRICANT")
@Getter
@Setter
public class Fabricant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FABRICANT", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "NOM_FABRICANT", nullable = false, length = 40)
    private String nomFabricant;

}

