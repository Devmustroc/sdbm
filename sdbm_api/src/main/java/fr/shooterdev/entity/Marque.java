package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "MARQUE")
@Getter
@Setter
public class Marque {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MARQUE", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "NOM_MARQUE", nullable = false, length = 40)
    private String nomMarque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAYS")
    private Pays idPays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FABRICANT")
    private Fabricant idFabricant;

}

