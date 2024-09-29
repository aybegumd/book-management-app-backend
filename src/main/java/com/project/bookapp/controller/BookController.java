package com.project.bookapp.controller;

import com.project.bookapp.entity.Book;
import com.project.bookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Book> updateBookAvailability(@PathVariable Long id, @RequestBody Map<String, Boolean> request) {
        long startTime = System.currentTimeMillis();

        boolean available = request.get("available");
        Book updatedBook = bookService.updateBookAvailability(id, available);

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("API yanıt süresi: " + duration + "ms");

        return ResponseEntity.ok(updatedBook);
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

}
