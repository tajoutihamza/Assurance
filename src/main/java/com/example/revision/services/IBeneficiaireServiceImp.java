package com.example.revision.services;

import com.example.revision.entities.Assurance;
import com.example.revision.entities.Beneficiaire;
import com.example.revision.entities.enums.TypeContrat;
import com.example.revision.repositories.AssuranceRepository;
import com.example.revision.repositories.BeneficiaireRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class IBeneficiaireServiceImp implements IBeneficiaireService {

    private final BeneficiaireRepository beneficiaireRepo;
    private final AssuranceRepository assuranceRepo;
    @Scheduled(fixedRate = 60000)
    public void statistiques(){
        log.info("hello");
        List<Beneficiaire> beneficiaires = beneficiaireRepo.findAll();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (var bf:beneficiaires) {
            int s = bf.getAssurances().size();
            map.put(s,bf.getCin());
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            log.info("number of assurances "+ entry.getKey().toString()+" , with is cin"+ entry.getValue().toString());
        }
    }

    @Override
    public Beneficiaire ajouterBeneficaire ( @RequestBody Beneficiaire bf) throws IllegalArgumentException{
        if(bf.getCin()==0||bf.getProfession()==null||bf.getSalaire()==0){
            throw new IllegalArgumentException("cin, profession, and salaire must be non-null");
        }
        return beneficiaireRepo.save(bf);
    }
    @Override
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat){
        Set<Assurance> assurances = assuranceRepo.findAssurancesByContrat_Type(typeContrat);
        Set<Beneficiaire> hashMap = new HashSet<>();
        for (var assurance:assurances) {
            hashMap.add(assurance.getBeneficiaire());
        }
        return hashMap;
    }

}
