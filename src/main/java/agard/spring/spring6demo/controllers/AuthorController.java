package agard.spring.spring6demo.controllers;

import agard.spring.spring6demo.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    // Fields //
    private final AuthorService authorService;

    //Constructors //
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Public Methods //
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
