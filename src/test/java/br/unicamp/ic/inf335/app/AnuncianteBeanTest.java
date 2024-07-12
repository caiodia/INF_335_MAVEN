package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuncianteBeanTest {

    private static ArrayList<URL> fotosUrl = new ArrayList<URL>();
    private static ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();

    @Test
    public void testNome() {
        AnuncianteBean anunciante = new AnuncianteBean();
        String nome = "João da Silva";
        anunciante.setNome(nome);

        assertEquals(nome, anunciante.getNome());
    }

    @Test
    public void testCPF() {
        AnuncianteBean anunciante = new AnuncianteBean();
        String CPF = "123.456.789-00";
        anunciante.setCPF(CPF);

        assertEquals(CPF, anunciante.getCPF());
    }

    @Test
    public void testAnuncios() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean();
        ArrayList<AnuncioBean> anuncios = new ArrayList<>();

        AnuncioBean anuncio1 = new AnuncioBean();
        ProdutoBean produto1 = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",100.00,"Poucos riscos, estado de novo.");
        anuncio1.setProduto(produto1);
        anuncio1.setDesconto(10.0);
        ArrayList<URL> fotos1 = new ArrayList<>();
        fotos1.add(new URL("http://example.com/foto1"));
        anuncio1.setFotosUrl(fotos1);

        AnuncioBean anuncio2 = new AnuncioBean();
        ProdutoBean produto2 = new ProdutoBean("CD00002","Celular Galaxy S10", "128 Gb, Preto, com Carregador",100.00,"Poucos riscos, estado de novo.");
        anuncio2.setProduto(produto2);
        anuncio2.setDesconto(20.0);
        ArrayList<URL> fotos2 = new ArrayList<>();
        fotos2.add(new URL("http://example.com/foto2"));
        anuncio2.setFotosUrl(fotos2);

        anuncios.add(anuncio1);
        anuncios.add(anuncio2);

        anunciante.setAnuncios(anuncios);

        assertEquals(anuncios, anunciante.getAnuncios());
        assertEquals(2, anunciante.getAnuncios().size());
        assertEquals(produto1, anunciante.getAnuncios().get(0).getProduto());
        assertEquals(produto2, anunciante.getAnuncios().get(1).getProduto());
    }

    @Test
    public void testaValorMedioAnuncios() throws URISyntaxException, MalformedURLException {

        ProdutoBean produtoBean = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",100.00,"Poucos riscos, estado de novo.");

        String aURIString = "http://somehost:80/path?thequery";
        URL url = new URL(aURIString);
        fotosUrl.add(url);

        AnuncioBean anuncioBean = new AnuncioBean(produtoBean, fotosUrl, 0.2);
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean, fotosUrl, 0.5);
        AnuncioBean anuncioBean3 = new AnuncioBean(produtoBean, fotosUrl, 0.8);

        anuncios.add(anuncioBean);
        anuncios.add(anuncioBean2);
        anuncios.add(anuncioBean3);

        AnuncianteBean anuncianteBean = new AnuncianteBean("VaiDeBet","111.111.111-53", anuncios);

        anuncianteBean.addAnuncio(anuncioBean);
        anuncianteBean.addAnuncio(anuncioBean2);
        anuncianteBean.addAnuncio(anuncioBean3);

        Double resultado = anuncianteBean.valorMedioAnuncios();
        System.out.println(resultado);

        assertEquals(50.0, resultado);
    }

    @Test
    public void removeAnuncios() throws URISyntaxException, MalformedURLException {

        ProdutoBean produtoBean = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",100.00,"Poucos riscos, estado de novo.");

        String aURIString = "http://somehost:80/path?thequery";
        URL url = new URL(aURIString);
        fotosUrl.add(url);

        AnuncioBean anuncioBean = new AnuncioBean(produtoBean, fotosUrl, 0.2);
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean, fotosUrl, 0.5);
        AnuncioBean anuncioBean3 = new AnuncioBean(produtoBean, fotosUrl, 0.8);

        anuncios.add(anuncioBean);
        anuncios.add(anuncioBean2);
        anuncios.add(anuncioBean3);

        AnuncianteBean anuncianteBean = new AnuncianteBean("VaiDeBet","111.111.111-53", anuncios);

        anuncianteBean.addAnuncio(anuncioBean);
        anuncianteBean.addAnuncio(anuncioBean2);
        anuncianteBean.addAnuncio(anuncioBean3);

        anuncianteBean.removeAnuncio(1);

        assertEquals(5, anuncianteBean.getAnuncios().size());
    }


    @Test
    public void addAnuncioTest() throws URISyntaxException, MalformedURLException {

        ProdutoBean produtoBean = new ProdutoBean("CD00009","Celular Galaxy S10", "128 Gb, Preto, com Carregador",100.00,"Poucos riscos, estado de novo.");

        String aURIString = "http://somehost:80/path?thequery";
        URL url = new URL(aURIString);
        fotosUrl.add(url);

        AnuncioBean anuncioBean = new AnuncioBean(produtoBean, fotosUrl, 0.2);
        ArrayList<AnuncioBean> anuncios2 = new ArrayList<>();
        anuncios2.add(anuncioBean);

        AnuncianteBean anuncianteBean = new AnuncianteBean("VaiDeBet","111.111.111-53", anuncios2);

        anuncianteBean.addAnuncio(anuncioBean);

        assertEquals(2, anuncianteBean.getAnuncios().size());
    }
}
