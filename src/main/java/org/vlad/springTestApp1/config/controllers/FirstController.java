package org.vlad.springTestApp1.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname",required = false) String surname,
                            Model model){
        model.addAttribute("message","Hello, " + name + " " + surname);
       return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage (){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request,Model model){
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String action = request.getParameter("action");
        int result;

        try {
        switch (action){
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
                break;
            case "multiplication":
                result = a * b;
                break;
            default: result = 0;
        }
        model.addAttribute("result", a + " " + action + " " + b  + " = " + result);}
        catch (ArithmeticException e) {
            model.addAttribute("result", "You can't divide by zero");
        }

        return "first/calculator";
    }
}
