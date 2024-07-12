package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {

    private static ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();

    @Test
    void testCompareTo() {
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descrição A", 10.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descrição B", 15.0, "Usado");

        // Testando se o compareTo considera a comparação dos valores corretamente
        assertTrue(produto1.compareTo(produto2) < 0); // produto1 deve ser menor que produto2
    }

    @Test
    void testGetCodigo() {
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertEquals("001", produto.getCodigo());
    }

    @Test
    void testGetNome() {
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertEquals("Celular Galaxy S10", produto.getNome());
    }

    @Test
    void testGetDescricao() {
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertEquals("Celular Galaxy S10", produto.getDescricao());
    }

    @Test
    void testGetValor() {
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertEquals(10.0, produto.getValor());
    }

    @Test
    void testGetEstado() {
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertEquals("São Paulo", produto.getEstado());
    }

    @Test
    void testSetCodigo() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("001");
        assertEquals("001", produto.getCodigo());
    }

    @Test
    void testSetNome() {
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Celular");
        assertEquals("Celular", produto.getNome());
    }

    @Test
    void testSetDescricao() {
        ProdutoBean produto = new ProdutoBean();
        produto.setDescricao("Celular Galaxy S10");
        assertEquals("Celular Galaxy S10", produto.getDescricao());
    }

    @Test
    void testSetValor() {
        ProdutoBean produto = new ProdutoBean();
        produto.setValor(10.0);
        assertEquals(10.0, produto.getValor());
    }

    @Test
    void testSetEstado() {
        ProdutoBean produto = new ProdutoBean();
        produto.setEstado("São Paulo");
        assertEquals("São Paulo", produto.getEstado());
    }

    @Test
    void  testGetters(){
        ProdutoBean produto = new ProdutoBean("001", "Celular Galaxy S10", "Celular Galaxy S10", 10.0, "São Paulo");
        assertAll("prosuto",
                () -> assertEquals("001", produto.getCodigo()),
                () -> assertEquals("Celular Galaxy S10", produto.getNome()),
                () -> assertEquals("Celular Galaxy S10", produto.getDescricao()),
                () -> assertEquals(10.0, produto.getValor())
                );
    }
}