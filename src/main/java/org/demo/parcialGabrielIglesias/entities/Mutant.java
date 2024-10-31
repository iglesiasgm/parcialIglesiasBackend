package org.demo.parcialGabrielIglesias.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "mutantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Mutant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "dna")
    private String dna;

    private boolean isMutant;
}
