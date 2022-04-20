package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Neil Alishev
 */
@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Name: " + name + ", Surname: " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String getCalculatorAnswer(@RequestParam(value = "a", required = false) int one,
                                      @RequestParam(value = "b", required = false) int two,
                                      @RequestParam(value = "action", required = false) String action, Model model){

        double result = 1;
        switch(action){
            case "multiplication":
                result = one * two;
                break;
            case "addition":
                result = one + two;
                break;
            case "subtraction":
                result = one - two;
                break;
            case "division":
                result = 1;
                if(two != 0){
                    result = one / (double)two;
                }
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("operation", result);
        return "first/calculator";
    }
}
