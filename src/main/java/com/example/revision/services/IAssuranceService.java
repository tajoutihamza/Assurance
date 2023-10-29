package com.example.revision.services;

import com.example.revision.entities.Assurance;

public interface IAssuranceService {
    public Assurance ajouterAssurance (Assurance a, int cinBf);
    public float getMontantBf (int cinBf);
}
