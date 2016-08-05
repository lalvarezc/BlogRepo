package com.nisum.blog.persistance;

import com.nisum.blog.model.Author;

public interface IAutor {

    public void create(Author author);
    public void read();
    public void update();
    public void delete();
}
