package com.qnit18.bookservice.query.projection;

import com.netflix.discovery.converters.Auto;
import com.qnit18.bookservice.command.data.Book;
import com.qnit18.bookservice.command.repository.BookRepository;
import com.qnit18.bookservice.query.model.BookResponseModel;
import com.qnit18.bookservice.query.queries.GetAllBookQuery;
import com.qnit18.bookservice.query.queries.GetBookByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBookQuery query){
        List<Book> list = bookRepository.findAll();

//        List<BookResponseModel> bookResponseModels = new ArrayList<>();
//        list.forEach(book -> {
//            BookResponseModel bookResponseModel = new BookResponseModel();
//            BeanUtils.copyProperties(book, bookResponseModel);
//            bookResponseModels.add(bookResponseModel);
//        });

        List<BookResponseModel> listBooks =  list.stream()
                .map(book -> {
                    BookResponseModel bookResponseModel = new BookResponseModel();
                    BeanUtils.copyProperties(book, bookResponseModel);
            return bookResponseModel;
        }).toList();

        return listBooks; //bookResponseModels
    }

    @QueryHandler
    public BookResponseModel handle(GetBookByIdQuery query) throws Exception {
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book book = bookRepository.findById(query.getId()).orElseThrow(() -> new Exception("Not found Book by Id:" + query.getId()));

        BeanUtils.copyProperties(book, bookResponseModel);

        return bookResponseModel;
    }
}
