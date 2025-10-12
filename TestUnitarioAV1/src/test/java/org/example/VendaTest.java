package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class VendaTest {
    private Produto produto;
    private Venda venda;
    @BeforeEach
    public void setup(){
        this.produto=new Produto("Leite CCGL",19,50);
        this.venda=new Venda(produto, 5);

    }
    @Test
    public void deveVenderDentroLimite(){
        Venda vendaTest= new Venda(produto, 5);
        assertTrue(venda.realizarVenda());
    }
    @Test
    public void deveVenderNoLimite(){
        Venda vendaTest= new Venda(produto, 50);
        assertTrue(venda.realizarVenda());
    }
    @Test
    public void deveVenderForaLimite(){
        Venda vendaTest= new Venda(produto, 53);
        assertFalse(venda.realizarVenda());
    }
    @Test
    public void deveTestarValorTotal(){
        venda.realizarVenda();
        assertEquals(produto.getPreco()*5,venda.getTotalVenda());
    }
    @Test
    public void deveAumentarEstoquePosVenda(){
        venda.realizarVenda();
        produto.aumentarEstoque(4);
        assertEquals(49,produto.getEstoque());
    }
    @Test
    public void deveDiminuirEstoquePosVenda(){
        venda.realizarVenda();
        assertEquals(45,produto.getEstoque());
    }
    @Test
    public void deveFazerVendaProdutoInexistente(){
        Venda vendaTest=new Venda(null,1);
        assertThrows(NullPointerException.class, ()-> new Venda(null,1));
        
    }
    @Test
    public void deveFazerVendaQuantidadeNegativa(){
        Venda vendaTest=new Venda(produto,-1);
        assertFalse(vendaTest.realizarVenda());
        
    }
    @Test
    public void deveQuantidadeEstoqueInsuficiente(){
        Venda vendaTest= new Venda(produto, 53);
        vendaTest.realizarVenda();
        assertEquals(50,produto.getEstoque());
        
    }
    @Test
    public void deveTestarDiversasVendas(){
        Produto produto1= new Produto("Molho de Tomate",2.30, 60);
        Produto produto2= new Produto("Carne Hamburguer",5, 30);
        Produto produto3= new Produto("Queijo ",15, 100);
        Venda venda1= new Venda(produto1, 3);
        Venda venda2= new Venda(produto1, 3);
        Venda venda3= new Venda(produto1, 3);
        
        assertTrue(venda1.realizarVenda());
        assertTrue(venda2.realizarVenda());
        assertTrue(venda3.realizarVenda());
        
        
    }
    @Test
public void deveCalcularTotalCorretamenteQuandoPrecoAlteradoAntesDaVenda() {
    produto.setPreco(25.0);
    Venda vendaTest = new Venda(produto, 2);
    vendaTest.realizarVenda();
    assertEquals(50.0, vendaTest.getTotalVenda());
}

@Test
public void deveFalharVendaQuandoEstoqueInicialZero() {
    Produto produtoZerado = new Produto("Arroz", 10.0, 0);
    Venda vendaTest = new Venda(produtoZerado, 1);
    assertFalse(vendaTest.realizarVenda());
}

@Test
public void deveAumentarEstoqueEPermitirVendaAposReposicao() {
    Produto produtoZerado = new Produto("Feijão", 8.0, 0);
    Venda vendaTest = new Venda(produtoZerado, 2);
    assertFalse(vendaTest.realizarVenda());

    produtoZerado.aumentarEstoque(5);
    Venda novaVenda = new Venda(produtoZerado, 2);
    assertTrue(novaVenda.realizarVenda());
    assertEquals(3, produtoZerado.getEstoque());
}
}
