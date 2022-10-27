package com.study.MyBag.Controller;

import com.study.MyBag.Service.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BagController {
    private BagService service;
    @Autowired
    public BagController(BagService service) {
        this.service = service;
    }

    @GetMapping("age")
    public int age() {
        int age = service.age();
        return age;
    }
}
