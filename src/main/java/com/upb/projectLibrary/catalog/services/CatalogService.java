package com.upb.projectLibrary.catalog.services;

import com.upb.projectLibrary.catalog.entities.BookEntity;
import com.upb.projectLibrary.catalog.models.Book;
import com.upb.projectLibrary.catalog.repositories.IBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    private IBookRepository bookRepostory;

    @Override
    public Book getBookById(String id) {
        BookEntity bookEntity = bookRepostory.findById(id).orElse(null);

        if (bookEntity==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El libro no existe");
        }

        Book book = new Book();
        BeanUtils.copyProperties(bookEntity, book);
        return book;
    }

    @Override
    public List<Book> getBooks() {
        List<BookEntity> bookEntities = this.bookRepostory.findAll();
        List<Book> booksList = bookEntities
                .stream().map(bookEntity -> {
                    Book book = new Book();
                    BeanUtils.copyProperties(bookEntity, book);
                    return book;
                }).collect(Collectors.toList());

        return booksList;
    }

}
