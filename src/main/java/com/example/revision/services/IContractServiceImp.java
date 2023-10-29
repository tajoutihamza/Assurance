package com.example.revision.services;

import com.example.revision.entities.Contrat;
import com.example.revision.repositories.ContratRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IContractServiceImp implements IContractService{

    private final ContratRepository contratRepo;

    @Override
    public Contrat getContratBf(int idBf) {
        return null;
    }
}
