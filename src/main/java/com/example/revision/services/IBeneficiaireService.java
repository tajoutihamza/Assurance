package com.example.revision.services;

import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.enums.TypeContrat;

import java.util.Set;

public interface IBeneficiaireService {
    public Beneficiaire ajouterBeneficaire (Beneficiaire bf);
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat);
}
