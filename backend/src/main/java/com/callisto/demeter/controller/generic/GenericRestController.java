package com.callisto.demeter.controller.generic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericRestController {

    @GetMapping("/generic")
    public String home() {
        return "hello, home!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "hello, secured!";
    }
}
