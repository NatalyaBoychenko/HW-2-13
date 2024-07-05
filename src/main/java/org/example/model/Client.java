package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min=3, max=200)
    private String name;

    @Column(nullable = false)
    @ToString.Exclude
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
}
