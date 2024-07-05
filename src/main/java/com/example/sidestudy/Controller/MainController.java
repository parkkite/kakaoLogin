package com.example.sidestudy.Controller;

import com.example.sidestudy.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {


    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/api1")
    public ResponseEntity api1(Model model){
        return new ResponseEntity<>("로그인 성공 화면입니다.", HttpStatus.OK);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return "Principal is null";
        }
        HashMap hm =principal.getAttribute("properties");

        return "Welcome, " + hm.get("nickname").toString();
    }

    @GetMapping("/token")
    public Map<String, String> getToken(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new RuntimeException("Principal is null");
        }
        String accessToken = jwtUtil.generateAccessToken(principal.getAttribute("email"));
        String refreshToken = jwtUtil.generateRefreshToken(principal.getAttribute("email"));

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);

        return tokens;
    }
}
