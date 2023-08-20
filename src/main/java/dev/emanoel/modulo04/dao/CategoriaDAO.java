package dev.emanoel.modulo04.dao;

import dev.emanoel.modulo03.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
       this.entityManager.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }
}
