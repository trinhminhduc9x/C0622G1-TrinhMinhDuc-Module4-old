package com.spring_boot.controller;

import com.spring_boot.model.Product;
import com.spring_boot.service.ICategoryService;
import com.spring_boot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public String showStudentList(Model model) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());

        model.addAttribute("product",new Product());
        return "/blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());

        return "/category/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("success", "Delete new success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/product/list";
    }


}