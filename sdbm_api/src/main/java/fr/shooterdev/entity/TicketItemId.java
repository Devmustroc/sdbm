package fr.shooterdev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class TicketItemId implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;
    @NotNull
    private Long numeroTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketItemId that = (TicketItemId) o;
        return Objects.equals(id, that.id) && Objects.equals(numeroTicket, that.numeroTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroTicket);
    }
}
