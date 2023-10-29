package com.example.revision.services;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.Contrat;
import com.example.revision.entities.enums.TypeContrat;
import com.example.revision.repositories.AssuranceRepository;
import com.example.revision.repositories.BeneficiaireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IAssuranceServiceImp implements IAssuranceService {

    private final AssuranceRepository assuranceRepo;
    private final BeneficiaireRepository beneficiaireRepo;
    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf) {
        Beneficiaire bf = beneficiaireRepo.findByCin(cinBf);
        a.setBeneficiaire(bf);
        assuranceRepo.save(a);
        return a;
    }
    @Override
    public float getMontantBf (int cinBf){
        List<Assurance>assurances = assuranceRepo.findAssurancesByBeneficiaire_Cin(cinBf);
        float sum = 0;
        for (var ass: assurances) {
            float mont = 0;
            if(ass.getContrat().getType().equals(TypeContrat.Semestriel))
                 mont = ass.getMontant()*2;
            else if(ass.getContrat().getType().equals(TypeContrat.Mensuel))
                mont = ass.getMontant()*12;
            else mont = ass.getMontant();

            sum += mont;
        }
        return sum;
    }
}
