package mate.academy.repository.book;

import java.util.List;
import java.util.Optional;
import mate.academy.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    @Override
    List<Book> findAll(Specification<Book> spec);

    @Override
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
