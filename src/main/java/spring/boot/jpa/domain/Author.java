package spring.boot.jpa.domain;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;

}
