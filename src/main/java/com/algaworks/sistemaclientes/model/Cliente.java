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

//    @ElementCollection
//    @CollectionTable(name = "cliente_endereco",
//            joinColumns = @JoinColumn(name = "cliente_id"))
//    @Column(name = "endereco")
//    private List<String> enderecos;

//    @ElementCollection
//    @CollectionTable(name = "cliente_endereco",
//            joinColumns = @JoinColumn(name = "cliente_id"))
//    private List<Endereco> enderecos;

//    @ElementCollection
//    @CollectionTable(name = "cliente_endereco",
//            joinColumns = @JoinColumn(name = "cliente_id"))
//    @Column(name = "endereco")
//    @MapKeyColumn(name = "tipo")
//    private Map<String, String> enderecos;

//    @ElementCollection
//    @CollectionTable(name = "cliente_endereco",
//            joinColumns = @JoinColumn(name = "cliente_id"))
//    @MapKeyColumn(name = "tipo")
//    private Map<String, Endereco> enderecos;

    @ElementCollection
    @CollectionTable(name = "cliente_endereco",
            joinColumns = @JoinColumn(name = "cliente_id"))
    @MapKeyColumn(name = "tipo")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<TipoEndereco, Endereco> enderecos;
}
