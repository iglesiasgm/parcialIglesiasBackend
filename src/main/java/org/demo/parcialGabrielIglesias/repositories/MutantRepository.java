package org.demo.parcialGabrielIglesias.repositories;

import org.demo.parcialGabrielIglesias.entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {
    Optional<Mutant> findByDna(String dnaSequence);

    long countByIsMutant(boolean isMutant);
}
