package com.example.sidestudy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/api1")
    public ResponseEntity api1(){
        return new ResponseEntity<>("로그인 성공 화면입니다.", HttpStatus.OK);
    }
}
