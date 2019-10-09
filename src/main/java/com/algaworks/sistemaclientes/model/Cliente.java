package com.algaworks.sistemaclientes.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

//    private List<String> enderecos;

//    private List<Endereco> enderecos;

//    private Map<String, String> enderecos;

//    private Map<String, Endereco> enderecos;

//    private Map<TipoEndereco, Endereco> enderecos;


}
