package fr.shooterdev.entity;

import java.util.Date;
import java.time.LocalTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TICKET")
public class TicketEntity {

    @EmbeddedId
 	private TicketItemId id;

    @Column (name="HEURE_VENTE")
    @NotNull
    private Date dateVente;

    @Column (name="HEURE_VENTE")
    @NotNull
    private LocalTime heureVente;

}
