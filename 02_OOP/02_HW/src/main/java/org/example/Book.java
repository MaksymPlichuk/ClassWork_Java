package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String authorName;
    private int publishYear;
    private String publisher;
    private String genre;
    private int numberOfPages;

    public Book(){
        this.name="Atomic Habits";
        this.authorName="James Clear";
        this.publishYear=2018;
        this.publisher="British Book";
        this.genre="Self-Help";
        this.numberOfPages=308;
    }
    @Override
    public String toString(){
        return "Name: %s Author: %s Year: %d publisher: %s genre: %s pages: %d".formatted(name,authorName,publishYear,publisher,genre,numberOfPages);
    }
}
