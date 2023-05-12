package afn.xloop.booktracker_cnsd23;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo){
        this.repo = repo;
    }

    //localhost:8080/books
    @PostMapping("/add")
    public Response createBook(@RequestBody Book book){
        this.repo.save(book);
        Book getBook = this.repo.getBook(book.getId());
        Response res = new Response(true, getBook, "Book added successfully");
        ObjectMapper obj = new ObjectMapper();
        // obj.readValue(res, Response.class);
        return res;
    }

    @GetMapping("/all")
    public Collection<Book> getAllBooks(){
        return this.repo.getAllBook();
    }
}
