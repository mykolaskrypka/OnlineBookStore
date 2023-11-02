package mate.academy.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
