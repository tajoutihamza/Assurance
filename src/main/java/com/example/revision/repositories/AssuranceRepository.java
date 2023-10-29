package com.example.revision.repositories;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Contrat;
import com.example.revision.entities.enums.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
    public List<Assurance> findAssurancesByBeneficiaire_Cin(int cin);
    public Set<Assurance> findAssurancesByContrat_Type(TypeContrat typeContrat);
}