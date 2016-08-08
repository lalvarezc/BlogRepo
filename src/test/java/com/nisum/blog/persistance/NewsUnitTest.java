package com.nisum.blog.persistance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nisum.blog.model.Author;
import com.nisum.blog.model.News;


@RunWith(JUnit4.class)
public class NewsUnitTest {

    @Test
    public void checkIntance() throws Exception {
        NewsImpl noticia;

        noticia = new NewsImpl();

        Assert.assertNotNull(noticia);
    }

    @Test
    public void createNew() throws Exception {
        NewsImpl noticia = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
    }

    @Test
    public void checkFields() throws Exception {
        NewsImpl noticia = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
        Assert.assertNotNull(miNoticia.getAuthor());
        Assert.assertNotNull(miNoticia.getTitle());
        Assert.assertNotNull(miNoticia.getContent());
    }

    @Test (expected = RuntimeException.class)
    public void checkCaminoInfeliz() throws Exception {
        NewsImpl noticia = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);
    }

    @Test
    public void checkDelete() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(11232343);

        assertNotNull(miNoticiaBorrada);
        assertTrue(listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkDelete2() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(54746857);
    }


    @Test
    public void checkRead() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(11232343);

        assertNotNull(miNoticia);
        assertTrue(!listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkRead2() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(11233);
    }
}
