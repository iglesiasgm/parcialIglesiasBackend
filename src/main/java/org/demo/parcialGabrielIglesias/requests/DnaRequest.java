package org.demo.parcialGabrielIglesias.requests;

import lombok.Getter;
import lombok.Setter;
import org.demo.parcialGabrielIglesias.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
