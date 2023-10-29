package com.example.revision.repositories;

import com.example.revision.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Integer> {
    public Beneficiaire findByCin(int cin);
}