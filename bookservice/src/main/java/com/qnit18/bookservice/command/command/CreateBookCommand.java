package com.qnit18.bookservice.command.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
