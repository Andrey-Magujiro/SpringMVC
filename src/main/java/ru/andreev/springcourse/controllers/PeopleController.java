package ru.andreev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.andreev.springcourse.dao.PeopleDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleDAO peopleDAO;

    @Autowired
    public PeopleController(PeopleDAO peopleDAO){
        this.peopleDAO = peopleDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("people", peopleDAO.show(id));
        return "people/show";
    }


}
