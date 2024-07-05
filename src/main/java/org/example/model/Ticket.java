package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanetId;

    @ManyToOne()
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanetId;
}
