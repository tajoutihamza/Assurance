package com.example.revision.entities;

import com.example.revision.entities.enums.TypeContrat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int id;
    String matricule;
    @Temporal(TemporalType.DATE)
    Date dateEffet;
    @Enumerated(EnumType.STRING)
    TypeContrat type;

}
