package mate.academy.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookDaoImpl implements BookRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert book into DB: "
                    + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT b from Book b", Book.class).getResultList();
        } catch (Exception e) {
            throw new EntityNotFoundException("Can't get all books from db", e);
        }
    }

    @Override
    public Book findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> getBookById = session.createQuery(
                    "FROM Book b WHERE b.id = :id", Book.class);
            getBookById.setParameter("id", id);
            return getBookById.getSingleResult();
        } catch (Exception e) {
            throw new EntityNotFoundException("Can't get book with id " + id + " from db", e);
        }
    }
}
