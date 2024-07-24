package com.qnit18.bookservice.command.event;

import com.qnit18.bookservice.command.data.Book;
import com.qnit18.bookservice.command.repository.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookEventsHandler {

    private static final Logger log = LoggerFactory.getLogger(BookEventsHandler.class);
    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    public void on(BookCreatedEvent event){
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookUpdatedEvent event){
        Optional<Book> fBook = bookRepository.findById(event.getId());

//        if (fBook.isPresent()){
//            Book book = fBook.get();
//            BeanUtils.copyProperties(event, book);
//            bookRepository.save(book);
//        }

        fBook.ifPresent(book -> {
            book.setName(event.getName());
            book.setAuthor(event.getAuthor());
            book.setIsReady(event.getIsReady());
            bookRepository.save(book);
        });
    }

    @EventHandler
    public void on(BookDeletedEvent event){
        try {
            bookRepository.findById(event.getId()).orElseThrow(() -> new Exception("Book not found by id" + event.getId()));
            bookRepository.deleteById(event.getId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
