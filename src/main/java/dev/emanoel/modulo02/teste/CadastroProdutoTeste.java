package dev.emanoel.modulo02.teste;

import dev.emanoel.modulo02.dao.ProdutoDAO;
import dev.emanoel.modulo02.model.Categoria;
import dev.emanoel.modulo02.model.Produto;
import dev.emanoel.modulo02.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProdutoTeste {

    public static void main(String[] args) {

     Produto produto = new Produto();
     produto.setNome("livro");
     produto.setDescricao("livro sociologia");
     produto.setPreco(new BigDecimal("50"));
     produto.setCategoria(Categoria.LIVROS);

     EntityManager entityManager = JPAUtil.getEntityManager();

     ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

     entityManager.getTransaction().begin();
     produtoDAO.cadastrar(produto);
     entityManager.getTransaction().commit();
     entityManager.close();

    }
}
