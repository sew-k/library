package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.Status;
import com.crud.library.domain.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTestSuite {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testFindAll() {
        //Given
        Book book1 = new Book(1L, null, null, Status.IN_STOCK);
        Book book2 = new Book(2L, null, null, Status.IN_STOCK);
        bookRepository.save(book1);
        bookRepository.save(book2);
        Long id1 = book1.getBookId();
        Long id2 = book2.getBookId();

        //When
        List<Book> fetchedList = bookRepository.findAll();

        //Then
        Assertions.assertFalse(fetchedList.isEmpty());
        Assertions.assertEquals(2, fetchedList.size());

        //CleanUp
        bookRepository.deleteById(id1);
        bookRepository.deleteById(id2);
    }

    @Test
    void testSave() {
        //Given
        Book book = new Book(null, null, null, Status.BORROWED);

        //When
        bookRepository.save(book);
        Long id = book.getBookId();
        Optional<Book> fetchedBook = bookRepository.findById(id);

        //Then
        Assertions.assertTrue(fetchedBook.isPresent());
        Assertions.assertEquals(Status.BORROWED, fetchedBook.get().getStatus());

        //CleanUp
        bookRepository.deleteById(id);
    }

    @Test
    void testFindById() {
        //Given
        Book book = new Book(null, null, null, Status.BORROWED);
        bookRepository.save(book);
        Long id = book.getBookId();

        //When
        Optional<Book> fetchedBook = bookRepository.findById(id);

        //Then
        Assertions.assertTrue(fetchedBook.isPresent());
        Assertions.assertEquals(Status.BORROWED, fetchedBook.get().getStatus());

        //CleanUp
        bookRepository.deleteById(id);
    }

    @Test
    void deleteById() {
        //Given
        Book book = new Book(null, null, null, Status.IN_STOCK);
        bookRepository.save(book);
        Long id = book.getBookId();

        //When
        bookRepository.deleteById(id);
        Optional<Book> deletedBook = bookRepository.findById(id);

        //Then
        Assertions.assertFalse(deletedBook.isPresent());

        //CleanUp
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}