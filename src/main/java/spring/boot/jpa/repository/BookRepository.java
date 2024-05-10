package spring.boot.jpa.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.jpa.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
