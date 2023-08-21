package dev.emanoel.modulo05;

import dev.emanoel.modulo05.dao.ProdutoDAO;
import dev.emanoel.modulo02.model.Produto;
import dev.emanoel.modulo02.util.JPAUtil;
import dev.emanoel.modulo03.dao.CategoriaDAO;
import dev.emanoel.modulo03.model.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroProduto {

    public static void main(String[] args) {
        //cadastrarProduto();

        //buscarProdutoPorId(1L);

        //List<Produto> produtos = buscarTodosProdutos();
        //produtos.forEach(p -> System.out.println(p.getNome()));

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        //List<Produto> ps = produtoDAO.buscarPorNome("livro");
        //ps.forEach(p -> System.out.println(p.getNome()));

        //List<Produto> ps = produtoDAO.buscarPorNomeDaCategoria("LIVROS");
        //ps.forEach(p -> System.out.println(p.getNome()));

        BigDecimal preco = produtoDAO.buscarPrecoDoProdutoComNome("controle");
        System.out.println(preco);
    }

    private static void cadastrarProduto() {
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

    private static Produto buscarProdutoPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        return produtoDAO.buscarPorID(id);
    }

    private static List<Produto> buscarTodosProdutos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        return produtoDAO.buscarTodos();
    }
}
