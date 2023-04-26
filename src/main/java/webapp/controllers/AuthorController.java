package webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import webapp.services.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthorController {
    
    private final AuthorService authorService;

    AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }
    
}
