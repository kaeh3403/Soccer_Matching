package com.soccermatching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/match-board")
public class MatchResultController {
	
	@GetMapping("{number}")
	public String get(@PathVariable("number") int number) {
		return "match-result";
	}

}
