package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ProdutoTest {
    private Produto produto;
    private String nomeProduto="Leite CCGL";
    private double precoProduto=9.50;
    private int estoqueProduto= 50;

    @BeforeEach
    public void setup(){
        this.produto= new Produto(nomeProduto, precoProduto,estoqueProduto);
    }

    @Test
    public void deveCriarProdutoValido(){
        assertNotNull(produto);
        assertEquals(nomeProduto, produto.getNome());
        assertEquals(precoProduto, produto.getPreco());
        assertEquals(estoqueProduto, produto.getEstoque());
    }

    @Test
    public void deveFalharPreçoNegativo(){
        Produto produtoTest=new Produto("MAÇÃ", -2, 9);
        Assertions.assertFalse(produtoTest.getPreco()>0);        
    
    }
    @Test
    public void deveFalharEstoqueNegativo(){
        Produto produtoTest=new Produto("MAÇÃ", 2, -9);
        Assertions.assertFalse(produtoTest.getEstoque()>0);
    }
    @Test
    public void deveTrocarNomeValido(){
        produto.setNome("Leite DaVaca");
        assertEquals("Leite DaVaca", produto.getNome());
    }
    @Test
    public void deveTrocarPrecoValido(){
        produto.setPreco(10);
        assertEquals(10, produto.getPreco());
    }
    @Test
    public void deveTrocarEstoqueValido(){
        produto.setEstoque(10);
        assertEquals(10, produto.getEstoque());
    }
    @Test
    public void deveTrocarPrecoInvalido(){
        produto.setPreco(-10);
        assertFalse(produto.getPreco()>0);
    }

}
