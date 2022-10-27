package com.study.MyBag.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bagController {
    @GetMapping("age")
    public String age() {
        return "age";
    }
}
