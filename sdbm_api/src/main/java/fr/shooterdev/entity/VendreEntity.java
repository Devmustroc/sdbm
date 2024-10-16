package fr.shooterdev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Column;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity(name="VENDRE")
public class VendreEntity {

    @EmbeddedId
    private VendreItemId vendreId;

    @Column(name = "QUANTITE")
    private Integer quantity;

    @Column(name = "PRIX_VENTE")
    private Float prixVente;

}
