package com.library.catalogserver.service.impl;

import com.library.catalogserver.entity.Book;
import com.library.catalogserver.repository.BookRepository;
import com.library.catalogserver.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("BOOK BY ID "+id+" NOT FOUND"));


    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
