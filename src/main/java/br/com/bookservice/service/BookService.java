package br.com.bookservice.service;

import br.com.bookservice.domain.model.Book;
import br.com.bookservice.domain.repository.BookRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final Environment environment;

    public BookService (BookRepository bookRepository, Environment environment) {
        this.bookRepository = bookRepository;
        this.environment = environment;
    }

    public Book findBook(Long id, String currency) {
        Book bookPersistido = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book unsuportted"));

        var port = environment.getProperty("local.server.port");
        bookPersistido.setEnvironment(port);

        return bookPersistido;
    }

}
