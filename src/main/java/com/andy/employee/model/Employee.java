package com.andy.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;// nom
    private String firstname; /// prenom
    private String lastname; // postnom
    private LocalDate birthday; // date de naissance
    private String birthplace; // lieu de naissance
    private String sex;
    private String address;// adresse physique
    private String telephone;// numero de telephone
    private String email;// adresse mail
    private String civilStatus;// Etat civil
    private Integer nbChild;// Nombre d'enfants
    private String post;// Poste ou foncton de l'employee
    private String department;// Departement de l'employee
    private String serialNumber;// matricule
    private LocalDate commitment;// date d'engagement
    private Double salary;// salaire
    private String documents;// ensemble des documents
    private String profile;// photo de profile
}
