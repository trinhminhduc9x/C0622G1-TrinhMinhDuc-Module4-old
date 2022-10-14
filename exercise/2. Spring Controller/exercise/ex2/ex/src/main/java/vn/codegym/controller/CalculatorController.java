package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.CalculatorService;

@Controller
@RequestMapping()
public class CalculatorController {
    int kq = 0;

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String home() {
        return "list";
    }

    @PostMapping("/ Calculator")
    public String vnd(@RequestParam("first-operand") int firstOperand, @RequestParam("second-operand") int secondOperand, @RequestParam("operator") char operator, Model model) {
        kq = this.calculatorService.calculate(firstOperand, secondOperand, operator);
        model.addAttribute("kq", kq);
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);


        return "list";

    }

}
