package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.ConvertService;
import vn.codegym.service.ConvertServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/convert")
public class ConvertController {


    @Autowired
    private ConvertService convertService;


    @GetMapping("/")
    public String showConvertingForm() {
        return "/list";
    }

    @PostMapping("/")
    public String showResult(@RequestParam float usd, Model model) {
        if (usd > 0) {
            float vnd = convertService.convert(usd);
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
            return "/list";
        } else {
            model.addAttribute("usd", "gia tri ko hop le");
            return "/list";
        }
    }
}

//    public String vnd (  @RequestParam("rate") float rate,  @RequestParam("usd") float usd,Model model ){
//
//        if (usd>0 && rate >0){
//            float vnd =  convertService.convert(usd);
//            model.addAttribute("usd",usd);
//            return "list";
//        }
//
////       if (usd>0 && rate >0){
////           float vnd =  convertService.convert(rate,usd);
////           model.addAttribute("usd",usd);
////           model.addAttribute("vnd",vnd);
////           return "list";
////       }
//
//        else{
//            model.addAttribute("usd","gia tri ko hop le");
////        model.addAttribute("rate","gia tri ko hop le");
//            return "list";
//        }
//    }


