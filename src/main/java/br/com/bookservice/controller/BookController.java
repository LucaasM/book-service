package br.com.bookservice.controller;

import br.com.bookservice.domain.model.Book;
import br.com.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "book-service")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}/{currency}")
    public ResponseEntity<?> findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        try {
            return ResponseEntity.ok().body(bookService.findBook(id, currency));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
