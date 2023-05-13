package afn.xloop.booktracker_cnsd23;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements IBookRepository<Book> {

    private Map<Integer, Book> booklistrepo;

    public BookRepository(){
        this.booklistrepo = new HashMap<>();
    }

    @Override
    public void save(Book book) {
        this.booklistrepo.put(book.getId(), book);
    }

    public Book getBook(int i){
        return booklistrepo.get(i);
    }

    @Override
    public Collection<Book> getAllBook() {
        return this.booklistrepo.values();
    }

    @Override
    public Book updateBook(Book book){
        this.booklistrepo.put(book.getId(), book);
        return this.getBook(book.getId());
    }

    public void deleteBook(int id) {
        this.booklistrepo.remove(id);
    }

}
