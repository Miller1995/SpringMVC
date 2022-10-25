package md.miller1995.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

       // System.out.println("Hello " + name + " " + surname);

        model.addAttribute("message","Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "operation", required = false) String operation,
                             Model model){

        double result;

        switch (operation){
           case "multiplication" :
               result = a * b;
               break;
           case "division" :
                result = a / b;
                break;
           case "subtraction" :
                result = a - b;
                break;
           case "addition" :
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);

       return "first/calculator";
    }
}