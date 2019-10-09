package com.algaworks.sistemaclientes;

import com.algaworks.sistemaclientes.model.Cliente;
import com.algaworks.sistemaclientes.model.Endereco;
import com.algaworks.sistemaclientes.model.TipoEndereco;

import javax.persistence.*;
import java.util.Collections;

public class ElementCollection {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Paraná");
        endereco.setNumero("1600");

        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setEnderecos(Collections.singletonMap(TipoEndereco.CASA, endereco));

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
