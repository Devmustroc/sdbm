package fr.shooterdev.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Embeddable
public class VendreItemId  implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long annee;
    @NotNull
    private Long numero_ticket;
    @NotNull
    private Long articleId;

    public VendreItemId() {}

    public VendreItemId(@NotNull Long annee, @NotNull Long numero_ticket, @NotNull Long articleId) {
        this.annee = annee;
        this.numero_ticket = numero_ticket;
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendreItemId that = (VendreItemId) o;
        return Objects.equals(annee, that.annee) && Objects.equals(numero_ticket, that.numero_ticket)
                && Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annee, numero_ticket, articleId);
    }
}
