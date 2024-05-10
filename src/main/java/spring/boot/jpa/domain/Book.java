package spring.boot.jpa.domain;


import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    // provide isbn when book is created
    private String isbn;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

}