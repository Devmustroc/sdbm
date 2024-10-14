package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TypeBiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TYPE", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Column(name = "NOM_TYPE", nullable = false, length = 25)
    private String nomType;

}