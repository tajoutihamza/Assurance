package com.example.revision.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString(exclude = "beneficiaire")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerer par la base
    @Setter(AccessLevel.NONE)
    int id;
    String designtion;
    float montant;
    @JsonIgnore
    @ManyToOne()
    Beneficiaire beneficiaire;
    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;

}
