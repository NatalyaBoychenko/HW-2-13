package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Planet {
    @Id
    private String id;

    @Length(min=1, max=500)
    @Pattern(regexp = "[A-Z0-9]+")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanetId", cascade = CascadeType.ALL)
    private List<Ticket> ticketsFromPlanet = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanetId", cascade = CascadeType.ALL)
    private List<Ticket> ticketsToPlanet = new ArrayList<>();


}
