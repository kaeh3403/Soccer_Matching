package com.soccermatching.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soccermatching.dao.MatchBoardDAO;
import com.soccermatching.dao.MemberDAO;
import com.soccermatching.dto.MatchBoardDTO;
import com.soccermatching.dto.MemberDTO;

@Controller
@RequestMapping("/match-register")
public class MatchBoardRegisterController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MatchBoardDAO matchBoardDAO;
	
	@GetMapping
	public String get(Principal principal, HttpServletResponse response) {
		if (principal != null) {
			System.out.println(principal.getName());

			MemberDTO memberDTO = memberDAO.read(principal.getName());

			response.addHeader("Member-Number", String.valueOf(memberDTO.getNumber()));

		}
		
		return "match-register";
	}
	
	@PostMapping
	public String register(MatchBoardDTO matchBoardDTO, RedirectAttributes redirectAttributes) {
		System.out.println(matchBoardDTO);
		matchBoardDTO.setAuthor(1);
		
		matchBoardDAO.create(matchBoardDTO);
		
		//redirectAttributes.addFlashAttribute("msg", 1);
		
		return "redirect:main?msg=1";
	}

}
