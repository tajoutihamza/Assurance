package com.example.revision.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerer par la base
    @Setter(AccessLevel.NONE)
    int id;
    @NonNull
    int cin;
    String nom;
    String prenom;
    @NonNull
    String profession;
    @NonNull
    float salaire;
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiaire")
    Set<Assurance> assurances;
}
