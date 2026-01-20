package other.packaging.byfeature.author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class AuthorRepository {
    private final List<Author> authors = new ArrayList<>();

    public Author save(Author author) {
        authors.add(author);
        return author;
    }

    public Optional<Author> findById(String id) {
        return authors.stream().filter(author -> author.id().equals(id)).findFirst();
    }

    public List<Author> findAll() {
        return authors;
    }

    public void delete(Author author) {
        authors.remove(author);
    }
}
