package org.demo.parcialGabrielIglesias.services;

import org.demo.parcialGabrielIglesias.requests.StatsResponse;
import org.demo.parcialGabrielIglesias.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final MutantRepository mutantRepository;

    @Autowired
    public StatsService(MutantRepository mutantRepository) {
        this.mutantRepository = mutantRepository;
    }

    public StatsResponse getStats() {
        long countMutantDna = mutantRepository.countByIsMutant(true);
        long countHumanDna = mutantRepository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}