package webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webapp.services.PublisherService;

@Controller
public class PublisherController {
    
    private final PublisherService publiserService;

    public PublisherController(PublisherService publisherService){
        this.publiserService = publisherService;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model){

        model.addAttribute("publishers", publiserService.findAll());

        return "publishers";
    }
}
