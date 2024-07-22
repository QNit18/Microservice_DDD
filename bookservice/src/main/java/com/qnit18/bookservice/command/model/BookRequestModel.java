package com.qnit18.bookservice.command.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestModel {
    private String bookId;

    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Author is mandatory")
    private String author;
    private Boolean isReady;
}
