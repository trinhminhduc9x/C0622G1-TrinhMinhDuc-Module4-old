package sing.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import sing.dto.SingDto;
import sing.model.Sing;
import sing.service.ISingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(" ")
public class SingController {


    @Autowired
    private ISingService singService;

    @GetMapping(" ")
    public String showList(Model model) {
        model.addAttribute("singPage", singService.findAll());
        return "/list";
    }


    @GetMapping("/create")
    public String showFormList(Model model) {
        model.addAttribute("SingDto", new SingDto());
        return "/create";
    }

    @PostMapping("/save")
    public String checkValidation(@Validated @ModelAttribute("singDto") SingDto singDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model) {
        new SingDto().validate(singDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "redirect:/";
        }else {
            Sing sing = new Sing();
            BeanUtils.copyProperties(singDto, sing);
            singService.save(sing);
            redirectAttributes.addFlashAttribute("message","Create form"+ sing.getName()+"ok");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("sing", singService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Sing sing) {
        singService.update(sing);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        singService.remove(id);
        redirect.addFlashAttribute("success", "Delete new success");
        return "redirect:/";
    }

 `

}
