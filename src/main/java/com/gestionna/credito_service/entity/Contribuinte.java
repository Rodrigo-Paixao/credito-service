package com.gestionna.credito_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTRIBUINTE")
public class Contribuinte {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cnpj;
    private String inscricaoMunicipal;
    private String endereco;
}

