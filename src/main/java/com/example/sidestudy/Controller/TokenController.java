package com.example.sidestudy.Controller;

import com.example.sidestudy.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/refresh-token")
    public Map<String, String> refreshToken(@RequestBody Map<String, String> tokenRequest) {
        String refreshToken = tokenRequest.get("refreshToken");
        String username = jwtUtil.extractUsername(refreshToken);

        if (jwtUtil.validateToken(refreshToken, username)) {
            String newAccessToken = jwtUtil.generateAccessToken(username);
            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", newAccessToken);
            return tokens;
        } else {
            throw new RuntimeException("Invalid Refresh Token");
        }
    }
}
