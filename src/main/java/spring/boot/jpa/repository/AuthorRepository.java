package spring.boot.jpa.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.jpa.domain.Author;


@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(Integer age);

    @Query("SELECT a from Author a where a.age < ?1")
    Iterable<Author> filterAgeLessThanXYZ(Integer age);
}
