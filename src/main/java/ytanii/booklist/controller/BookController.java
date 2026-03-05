package ytanii.booklist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ytanii.booklist.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books/search")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<String> search(@RequestParam String q){
        return bookService.searchBooks(q);
    }

}
