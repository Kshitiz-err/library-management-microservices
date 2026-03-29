package com.library.catalogserver.service;

import com.library.catalogserver.entity.Book;

import java.util.List;

public interface CatalogService {
    List<Book> getAll();
    Book getById(Long  id);
    Book addBook(Book book);
}