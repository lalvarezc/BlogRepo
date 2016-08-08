package com.nisum.blog.persistance;


import com.nisum.blog.model.News;

import java.util.ArrayList;

public class NewsImpl {

    ArrayList <News> misNoticias;

    public NewsImpl() {
        misNoticias = new ArrayList<>();
    }

    public News create(News miNoticiaAGuardar) throws RuntimeException{
        if (miNoticiaAGuardar.getAuthor() == null ||
                miNoticiaAGuardar.getTitle() == null ||
                miNoticiaAGuardar.getContent() == null) {
            throw new RuntimeException();
        }
        misNoticias.add(miNoticiaAGuardar);
        return miNoticiaAGuardar;
    }

    public News delete(int i) throws RuntimeException{
        for (int j = 0; j<misNoticias.size(); j++) {
            if ( misNoticias.get(j).getId() == i) {
                return misNoticias.remove(j);
            }
        }
        throw new RuntimeException();
    }

    public boolean isEmpty() {
        return misNoticias.isEmpty();
    }

    public News read(int i) throws RuntimeException{
        for (int j = 0; j<misNoticias.size(); j++) {
            if ( misNoticias.get(j).getId() == i) {
                return misNoticias.get(j);
            }
        }
        throw new RuntimeException();
    }
}
