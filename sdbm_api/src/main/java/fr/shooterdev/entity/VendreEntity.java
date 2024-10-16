package fr.shooterdev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@Entity(name="VENDRE")
public class VendreEntity {

    @EmbeddedId
    private VendreItemId vendreId;

    @ManyToOne
    @MapsId("vendreId")
    @JoinColumn(name = "VendreItemId")
    private VendreItemId vendreItemId;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "ARTICLE")
    private Article articleId;

    @Column(name = "QUANTITE")
    private Integer quantity;

    @Column(name = "PRIX_VENTE")
    private Float prixVente;

    public VendreEntity() {}

    public VendreEntity(VendreItemId vendreItemId, Article articleId, Integer quantity, Float prixVente) {
        this.id = new VendreItemId(VendreItemId.getId(), item.getId());
        this.order = order;
        this.articleId = articleId;
        this.quantity = quantity;
        this.prixVente = prixVente;
    }


}
