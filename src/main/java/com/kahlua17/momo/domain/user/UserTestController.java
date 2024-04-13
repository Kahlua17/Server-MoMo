package com.kahlua17.momo.domain.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
