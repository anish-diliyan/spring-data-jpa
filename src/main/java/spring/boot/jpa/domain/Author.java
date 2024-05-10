package spring.boot.jpa.domain;


import lombok.Builder;


@Builder
public class Author {

    private Long id;

    private String name;

    private Integer age;

}
