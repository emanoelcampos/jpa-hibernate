package dev.emanoel.modulo03.teste;

import dev.emanoel.modulo02.dao.ProdutoDAO;
import dev.emanoel.modulo02.model.Produto;
import dev.emanoel.modulo02.util.JPAUtil;
import dev.emanoel.modulo03.dao.CategoriaDAO;
import dev.emanoel.modulo03.model.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProdutoTeste {

    public static void main(String[] args) {

     Categoria categoria = new Categoria();
     categoria.setNome("livro");

     Produto produto = new Produto();
     produto.setNome("livro");
     produto.setDescricao("livro sql");
     produto.setPreco(new BigDecimal("80"));
     produto.setCategoria(categoria);

     EntityManager entityManager = JPAUtil.getEntityManager();
     ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
     CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

     entityManager.getTransaction().begin();

     categoriaDAO.cadastrar(categoria);
     produtoDAO.cadastrar(produto);

     entityManager.getTransaction().commit();
     entityManager.close();

    }
}
