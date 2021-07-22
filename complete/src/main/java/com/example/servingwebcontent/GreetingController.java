package com.example.servingwebcontent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public List<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting1 = new Greeting(counter.incrementAndGet(), String.format(template, name));
		Greeting greeting2 = new Greeting(counter.incrementAndGet(), String.format("Byebye, %s", name));
		return Arrays.asList(greeting1, greeting2);
	}
}
