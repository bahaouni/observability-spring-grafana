package com.example.observabilityspringgrafana.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder @ToString

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id ;
    private String nom ;
    private  double price ;
}
