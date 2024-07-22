package com.qnit18.bookservice.query.controller;

import com.qnit18.bookservice.query.model.BookResponseModel;
import com.qnit18.bookservice.query.queries.GetAllBookQuery;
import com.qnit18.bookservice.query.queries.GetBookByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BookResponseModel> getAllBooks(){
        GetAllBookQuery query = new GetAllBookQuery();
        return queryGateway.query(query,ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();

    }

    @GetMapping("/{bookId}")
    public BookResponseModel getBookById(@PathVariable String bookId){
        GetBookByIdQuery query = new GetBookByIdQuery(bookId);
        return queryGateway.query(query, ResponseTypes.instanceOf(BookResponseModel.class)).join();
    }
}
