package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "TICKET)
public class TicketEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
 	@Column(name = "ANNEE", nullable = false)
	private Long id;

    @Id
    @NotNull
	@Column (name="NUMERO_TICKET")
 	private Long numero_ticket;

    @OneToMany()
  	private List<TicketEntity> marques = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNumero_ticket() {
        return Numero_ticket;
    }

    public void setNomPays(String name) {
        this.nomPays = name;
    }

}

