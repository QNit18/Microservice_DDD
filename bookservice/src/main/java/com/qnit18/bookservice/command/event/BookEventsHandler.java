package com.qnit18.bookservice.command.event;

import com.qnit18.bookservice.command.data.Book;
import com.qnit18.bookservice.command.repository.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookEventsHandler {

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

        if (fBook.isPresent()){
            Book book = fBook.get();
            BeanUtils.copyProperties(event, book);
            bookRepository.save(book);
        }
    }

    @EventHandler
    public void on(BookDeletedEvent event){
        bookRepository.deleteById(event.getId());
    }
}
