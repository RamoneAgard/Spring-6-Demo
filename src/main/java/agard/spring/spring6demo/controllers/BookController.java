package agard.spring.spring6demo.controllers;

import agard.spring.spring6demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    // Fields //
    private final BookService bookService;

    // Constructors  //
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Public methods //
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

}
