package com.kahlua17.momo.domain.user;

import com.kahlua17.momo.domain.user.entity.User;
import com.kahlua17.momo.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/nickname")
    public ResponseEntity<?> signup(@RequestHeader("UUID") String uuid, @RequestBody Map<String, String> body) {
        String nickname = body.get("nickname");
        if (nickname == null || nickname.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "잘못된 요청 데이터"));
        }

        User user = userService.registerUser(uuid, nickname);
        return ResponseEntity.ok(Map.of("message", "등록 성공", "userId", user.getId()));
    }
}