package com.sparta.week02.security.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SwaggerRedirector {
    @GetMapping("/swagger")
    public String api() { return "redirect:/swagger-ui.html"; }
}