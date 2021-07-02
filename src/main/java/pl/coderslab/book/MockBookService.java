package pl.coderslab.book;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {

    private List<Book> list = new ArrayList<>();

    public List<Book> findAllBooks() {

        return list;
    }

    public Book findById(long id) {

        return list.stream()
                .filter((element) -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void edit(Book book) {
        Book currentBook = findById(book.getId());
        if (currentBook != null) {
            currentBook.setAuthor(book.getAuthor());
            currentBook.setIsbn(book.getIsbn());
            currentBook.setTitle(book.getTitle());
            currentBook.setType(book.getType());
            currentBook.setPublisher(book.getPublisher());
        }
    }

    public void delete(long id) {
        list.removeIf((element) -> element.getId().equals(id));
    }

    public Book createBook(Book book) {

        book.setId((long) (list.size() + 1));
        list.add(book);
        return book;
    }
}
