package other.packaging.bylayer.repository;

import other.packaging.bylayer.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public Book save(Book book) {
        books.add(book);
        return book;
    }

    public Optional<Book> findById(String id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst();
    }

    public List<Book> findAll() {
        return books;
    }

    public void delete(Book book) {
        books.remove(book);
    }

}
