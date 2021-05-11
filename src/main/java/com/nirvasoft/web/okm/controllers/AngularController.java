package com.nirvasoft.web.okm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {
    @GetMapping(path = { "angular/**", "angular/" })
    public String index() {
        return "index.html";
    }
}
