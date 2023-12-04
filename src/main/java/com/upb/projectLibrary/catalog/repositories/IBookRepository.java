package com.upb.projectLibrary.catalog.repositories;

import com.upb.projectLibrary.catalog.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<BookEntity, String> {
}
