package afn.xloop.booktracker_cnsd23;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // localhost:8080/books
    @PostMapping("/add")
    public Response createBook(@RequestBody Book book) {
        this.repo.save(book);
        Book getBook = this.repo.getBook(book.getId());
        Response res = new Response(true, "Book added successfully", getBook);
        return res;
    }

    @GetMapping("/getBook")
    public Response getAllBooks(@RequestParam(name = "id", required = false) Integer id) {
        Object book;
        if (id != null) {
            book = this.repo.getBook(id);
        } else {
            
            book = this.repo.getAllBook();
        }
        
        Response res;
        if (book == null) {
            res = new Response(false, "Book(s) not found");
        } else {
            res = new Response(true, "Book(s) fetched successfully", book);
        }
        return res;
    }

    @PostMapping("/update")
    public Response updateBook(@RequestBody Book book){
        Book getBook = this.repo.getBook(book.getId());
        Response res;
        if(getBook == null){
            res = new Response(false, "Book not found");
        } else {
            getBook = this.repo.updateBook(book);
            res = new Response(true, "Book has been updated successfully", getBook);
        }
        return res;
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteBook(@PathVariable int id){
        Book getBook = this.repo.getBook(id);
        Response res;
        if(getBook == null){
            res = new Response(false, "Book not found");
        } else {
            this.repo.deleteBook(id);
            res = new Response(true, "Book has been deleted successfully");
        }
        return res;
    }
}
