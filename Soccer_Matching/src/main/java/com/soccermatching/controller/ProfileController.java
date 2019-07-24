package com.soccermatching.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccermatching.dao.MatchApplyDAO;
import com.soccermatching.dao.MatchBoardDAO;
import com.soccermatching.dao.MemberDAO;
import com.soccermatching.dto.MatchBoardDTO;
import com.soccermatching.dto.MemberDTO;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MatchBoardDAO matchBoardDAO;
	
	@Autowired
	private MatchApplyDAO matchApplyDAO;

	@GetMapping
	public String get(Principal principal, HttpServletResponse response) {
		if (principal != null) {
			System.out.println(principal.getName());

			MemberDTO memberDTO = memberDAO.read(principal.getName());

			response.addHeader("Member-Number", String.valueOf(memberDTO.getNumber()));

		}

		return "mypage";
	}
	
	@GetMapping("info")
	public @ResponseBody List<JsonNode> getInfo(Principal principal) {
		List<JsonNode> jsonNodes = new ArrayList<>();
		
		MemberDTO memberDTO = memberDAO.read(principal.getName());
		int number = memberDTO.getNumber();
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("name", memberDAO.read(number).getId());
		
		Map<String, List<MatchBoardDTO>> map2 = new HashMap<>();
		map2.put("apply", matchApplyDAO.readAppliedMatch(number));
		map2.put("register", matchBoardDAO.readRegisteredList(number));
		
		try {
			String str1 = new ObjectMapper().writeValueAsString(map1);
			String str2 = new ObjectMapper().writeValueAsString(map2);
			
			JsonNode jsonNode1 = new ObjectMapper().readTree(str1);
			JsonNode jsonNode2 =  new ObjectMapper().readTree(str2);
			
			jsonNodes.add(jsonNode1);
			jsonNodes.add(jsonNode2);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonNodes;
	}

}
