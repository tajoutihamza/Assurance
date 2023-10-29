package com.example.revision.repositories;

import com.example.revision.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    public Contrat findContratBy();

}