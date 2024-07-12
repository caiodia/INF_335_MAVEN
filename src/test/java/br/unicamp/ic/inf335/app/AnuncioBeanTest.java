package org.example;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioBeanTest {

    @Test
    public void testProduto() {
        AnuncioBean anuncio = new AnuncioBean();
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Descrição A", 10.0, "Novo");
        anuncio.setProduto(produto);

        assertEquals(produto, anuncio.getProduto());
        assertEquals("Produto A", anuncio.getProduto().getNome());
    }

    @Test
    public void testFotosUrl() throws MalformedURLException {
        AnuncioBean anuncio = new AnuncioBean();
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto1"));
        fotos.add(new URL("http://example.com/foto2"));
        anuncio.setFotosUrl(fotos);

        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(2, anuncio.getFotosUrl().size());
        assertEquals(new URL("http://example.com/foto1"), anuncio.getFotosUrl().get(0));
        assertEquals(new URL("http://example.com/foto2"), anuncio.getFotosUrl().get(1));
    }

    @Test
    public void testDesconto() {
        AnuncioBean anuncio = new AnuncioBean();
        Double desconto = 15.0;
        anuncio.setDesconto(desconto);

        assertEquals(desconto, anuncio.getDesconto());
    }

    @Test
    void testGetCodigo() {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        assertEquals("001", produto.getCodigo());
    }

    @Test
    void testGetNome() {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        assertEquals("Produto Teste", produto.getNome());
    }

    @Test
    void testGetDescricao() {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        assertEquals("Descrição do Produto", produto.getDescricao());
    }

    @Test
    void testGetValorComDesconto() throws MalformedURLException {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto1"));
        Double desconto = 0.15;
        AnuncioBean anuncio = new AnuncioBean();
        anuncio.setProduto(produto);
        anuncio.setFotosUrl(fotos);
        anuncio.setDesconto(desconto);

        assertEquals(8.5, anuncio.getValor());
    }

    @Test
    void testGetValor() {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        assertEquals(10.0, produto.getValor());
    }

    @Test
    void testGetEstado() {
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 10.0, "Novo");
        assertEquals("Novo", produto.getEstado());
    }
}