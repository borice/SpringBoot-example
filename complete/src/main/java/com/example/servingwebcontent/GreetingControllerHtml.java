package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingControllerHtml {
    private static final String template = "Cheers, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        Greeting greeting1 = new Greeting(counter.incrementAndGet(), String.format(template, name));
        Greeting greeting2 = new Greeting(counter.incrementAndGet(), String.format("Byebye, %s", name));
        model.addAttribute("greetings", Arrays.asList(greeting1, greeting2));
        return "greeting";
    }
}
