package com.example.revision.controllers;

import com.example.revision.entities.Assurance;
import com.example.revision.services.IAssuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("assurance")
@RequiredArgsConstructor
public class AssuranceController {
    @Qualifier("IAssuranceServiceImp")
    private final IAssuranceService assuranceService;
    @PostMapping("/{cinBf}")
    public Assurance ajouterAssurance(@RequestBody Assurance a,@PathVariable int cinBf) {
        return assuranceService.ajouterAssurance(a,cinBf);
    }
    @GetMapping("/sum/{cinBf}")
    public float getMontantBf (@PathVariable int cinBf){
        return assuranceService.getMontantBf(cinBf);
    }
    }
