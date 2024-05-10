package spring.boot.jpa.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.boot.jpa.TestDataUtil;
import spring.boot.jpa.domain.Author;
import spring.boot.jpa.domain.Book;
import spring.boot.jpa.repository.AuthorRepository;
import spring.boot.jpa.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    private final BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA();
        book.setAuthor(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        //assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthor(author);
        underTest.save(bookA);

        Book bookB = TestDataUtil.createTestBookB();
        bookB.setAuthor(author);
        underTest.save(bookB);

        Book bookC = TestDataUtil.createTestBookC();
        bookC.setAuthor(author);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();
        assertThat(result).hasSize(3);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthor(author);
        underTest.save(bookA);

        bookA.setTitle("UPDATED");
        underTest.save(bookA);

        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isPresent();
        //assertThat(result.get()).isEqualTo(bookA);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthor(author);
        underTest.save(bookA);

        underTest.deleteById(bookA.getIsbn());

        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isEmpty();
    }
}
