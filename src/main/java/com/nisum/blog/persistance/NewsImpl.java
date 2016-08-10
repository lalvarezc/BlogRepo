package com.nisum.blog.persistance;


import com.nisum.blog.model.News;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class NewsImpl {
	
	private final AtomicInteger counter = new AtomicInteger();

    ArrayList <News> misNoticias;

    public NewsImpl() {
        misNoticias = new ArrayList<>();
    }

    /**
     * Gets  the new id 
     * @return
     */
    private int newIdNews(){
    	
    	return counter.getAndIncrement();
    }
    
    public News create(News miNoticiaAGuardar) throws RuntimeException{
        if (!nullValidation(miNoticiaAGuardar)) {
            throw new RuntimeException();
        }
        miNoticiaAGuardar.setId(newIdNews());
        misNoticias.add(miNoticiaAGuardar);
        return miNoticiaAGuardar;
    }
    
    /**
     * Validates nulls 
     * @param miNoticiaAGuardar
     * @return
     */
    private  boolean nullValidation( News miNoticiaAGuardar){
    	
    	if(miNoticiaAGuardar.getAuthor() == null || miNoticiaAGuardar.getTitle() == null || miNoticiaAGuardar.getContent() == null){
    		return false;
    	}else{
    		return true;
    	}
    	
    	
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
