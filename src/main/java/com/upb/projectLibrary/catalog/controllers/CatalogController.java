package com.upb.projectLibrary.catalog.controllers;

import com.upb.projectLibrary.catalog.models.Book;
import com.upb.projectLibrary.catalog.services.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @GetMapping
    public List<Book> getAll(){
        return catalogService.getBooks();
    }

    @GetMapping("/:id")
    public Book getOneById(@PathVariable String id){
        return catalogService.getBookById(id);
    }
}
