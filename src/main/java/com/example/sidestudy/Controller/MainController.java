package com.example.sidestudy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/api1")
    public ResponseEntity api1(Model model){
        return new ResponseEntity<>("로그인 성공 화면입니다.", HttpStatus.OK);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
