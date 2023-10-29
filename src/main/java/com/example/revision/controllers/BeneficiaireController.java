package com.example.revision.controllers;

import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.enums.TypeContrat;
import com.example.revision.services.IBeneficiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("beneficiaire")
@RequiredArgsConstructor
public class BeneficiaireController {
    @Qualifier("IBeneficiaireServiceImp")
    private final IBeneficiaireService beneficiaireService;

@PostMapping()
    public Beneficiaire ajouterBeneficaire(Beneficiaire bf){
    return beneficiaireService.ajouterBeneficaire(bf);
}

    @GetMapping("/{typeContrat}")
    public Set<Beneficiaire> getBeneficairesAsType(@PathVariable TypeContrat typeContrat){
        return beneficiaireService.getBeneficairesAsType(typeContrat);
    }

}
