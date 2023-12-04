package com.upb.projectLibrary.catalog.services;

import com.upb.projectLibrary.catalog.models.Book;

import java.util.List;

public interface ICatalogService {
    Book getBookById(String id);
    List<Book> getBooks();
}
