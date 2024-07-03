package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Planet {
    @Id
    private String id;

    @Length(min=1, max=500)
    @Pattern(regexp = "[A-Z0-9]+")
    private String name;
}
