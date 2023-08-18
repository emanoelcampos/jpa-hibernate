package dev.emanoel.modulo02.dao;

import dev.emanoel.modulo02.model.Categoria;
import dev.emanoel.modulo02.model.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }
}
