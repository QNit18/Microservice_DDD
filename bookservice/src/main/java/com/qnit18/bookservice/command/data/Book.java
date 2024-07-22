package com.qnit18.bookservice.command.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    private String id;

    private String name;

    private String author;

    private Boolean isReady;
}
