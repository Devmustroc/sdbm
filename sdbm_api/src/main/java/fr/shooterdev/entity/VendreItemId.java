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
    private Long ticketItemId;
    @NotNull
    private Long articleId;

    public VendreItemId() {}

    public VendreItemId(@NotNull Long ticketItemId, @NotNull Long articleId) {
        this.ticketItemId = ticketItemId;
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendreItemId that = (VendreItemId) o;
        return Objects.equals(ticketItemId, that.ticketItemId)
                && Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketItemId, articleId);
    }
}
