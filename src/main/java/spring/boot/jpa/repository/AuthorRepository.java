package spring.boot.jpa.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.jpa.domain.Author;


@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
