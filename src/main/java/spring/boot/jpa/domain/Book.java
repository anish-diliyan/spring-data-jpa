package spring.boot.jpa.domain;


import lombok.Builder;

@Builder
public class Book {

    private String isbn;

    private String title;

    private Author author;

}