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
import com.soccermatching.dto.MemberDTO;

public class MypageController {

@RestController
@RequestMapping("/api/mypages")
public class MemberController {

	@Autowired
	private MypageDAO MypageDAO;

	@GetMapping("/{number}")
	public List<MatchBoardDTO> mypageAll(@PathVariable("number") int number) {
		return MypageDAO.ApplyList(number);
	}

	@GetMapping("/{number}")
	public List<MatchBoardDTO> getOne(@PathVariable("number") int number) {
		return MypageDAO.RegisterList(number);
	}

	}
}
