package com.algaworks.sistemaclientes;

import com.algaworks.sistemaclientes.model.Cliente;
import com.algaworks.sistemaclientes.model.Endereco;
import com.algaworks.sistemaclientes.model.TipoEndereco;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;

public class ElementCollection {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua São Paulo");
        endereco.setNumero("3000");
        endereco.setBairro("Centro");
        endereco.setCidade("Belo Horizonte");
        endereco.setCep("00000-000");

        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");

//        cliente.setEnderecos(Arrays.asList("Rua Paraná, 10, Bairro Brasil - Belo Horizonte/MG"));
//        cliente.setEnderecos(Arrays.asList(endereco));
//        cliente.setEnderecos(Collections.singletonMap(
//                "casa", "Rua São Paulo, 5000, Brasil - Belo Horizonte/MG"));
//        cliente.setEnderecos(Collections.singletonMap("casa", endereco));
        cliente.setEnderecos(Collections.singletonMap(TipoEndereco.CASA, endereco));

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
