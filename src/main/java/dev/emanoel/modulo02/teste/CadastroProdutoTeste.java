package dev.emanoel.modulo02.teste;

import dev.emanoel.modulo02.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProdutoTeste {

    public static void main(String[] args) {

     Produto produto = new Produto();
     produto.setNome("controle");
     produto.setDescricao("controle xbox");
     produto.setPreco(new BigDecimal("300"));

     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");

     EntityManager entityManager = entityManagerFactory.createEntityManager();

     entityManager.getTransaction().begin();
     entityManager.persist(produto);
     entityManager.getTransaction().commit();
     entityManager.clear();
    }
}
