package com.soccermatching.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatching.dao.MypageDAO;
import com.soccermatching.dto.MatchBoardDTO;

@RestController
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	private MypageDAO MypageDAO;
	
	@GetMapping("apply/{number}")
	public List<MatchBoardDTO> applyList(@PathVariable("number") int number) {
		return MypageDAO.ApplyList(number);
	}
	
	@GetMapping("register/{number}")
	public List<MatchBoardDTO> registerList(@PathVariable("number") int number) {
		return MypageDAO.RegisterList(number);
		
	}
}
		
		
		
		

