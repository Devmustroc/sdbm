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
public class TicketItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;
    @NotNull
    private Long numeroTicket;

    public TicketItem() {}

    public TicketItem(@NotNull Long id, @NotNull Long numeroTicket) {
        this.id = id;
        this.numeroTicket = numeroTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketItem that = (TicketItem) o;
        return Objects.equals(id, that.id) && Objects.equals(numeroTicket, that.numeroTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroTicket);
    }
}
