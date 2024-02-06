package mate.academy.repository.book;

import java.util.Optional;
import mate.academy.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Override
    Book save(Book book);

    @Override
    Page<Book> findAll(Pageable pageable);

    @Override
    Page<Book> findAll(Specification<Book> spec, Pageable pageable);

    @Override
    Optional<Book> findById(Long id);

    @Query("SELECT book FROM Book book join fetch book.categories cat where cat.id = :categoryId")
    Page<Book> findAllByCategoryId(Long categoryId, Pageable pageable);

    @Override
    void deleteById(Long id);
}
