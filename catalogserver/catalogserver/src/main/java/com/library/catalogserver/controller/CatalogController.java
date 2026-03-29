package com.library.catalogserver.controller;

import com.library.catalogserver.entity.Book;
import com.library.catalogserver.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public List<Book> getAll(){
        return catalogService.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return catalogService.getById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return catalogService.addBook(book);
    }
}
