package com.soccermatching.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soccermatching.dao.MatchApplyDAO;
import com.soccermatching.dao.MatchBoardDAO;
import com.soccermatching.dto.MatchApplyDTO;



@Controller
@RequestMapping("/match-board")
public class MatchResultController {
	
	@Autowired
	private MatchApplyDAO matchApplyDAO;
	@Autowired
	private MatchBoardDAO matchBoardDAO;
	
	@GetMapping("{number}")
	public String get(@PathVariable("number") int number) {
		return "main-match-result";
	}
	@PostMapping
	public ResponseEntity<?> register(MatchApplyDTO matchApplyDTO, HttpServletResponse response) {
		System.out.println(matchApplyDTO);
		
		if(isAppliable(matchApplyDTO.getMatchBoardNumber())) {
			matchApplyDAO.create(matchApplyDTO);
			

			return new ResponseEntity<>(1, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
	}
	
	private boolean isAppliable(int matchBoardNumber) {
		int numberAppliable = matchBoardDAO.readNumberAppliable(matchBoardNumber);
		int count = matchApplyDAO.count(matchBoardNumber);
		
		return numberAppliable - count> 0;
	}
	
}
