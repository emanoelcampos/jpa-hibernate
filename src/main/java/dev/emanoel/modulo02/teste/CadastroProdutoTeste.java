package dev.emanoel.modulo02.teste;

import dev.emanoel.modulo02.dao.ProdutoDAO;
import dev.emanoel.modulo02.model.Produto;
import dev.emanoel.modulo02.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProdutoTeste {

    public static void main(String[] args) {

     Produto produto = new Produto();
     produto.setNome("headset");
     produto.setDescricao("headset preto");
     produto.setPreco(new BigDecimal("150"));

     EntityManager entityManager = JPAUtil.getEntityManager();

     ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

     entityManager.getTransaction().begin();
     produtoDAO.cadastrar(produto);
     entityManager.getTransaction().commit();
     entityManager.close();

    }
}
