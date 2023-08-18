package dev.emanoel.modulo02.dao;

import dev.emanoel.modulo02.model.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto ) {
        this.entityManager.persist(produto);
    }
}
