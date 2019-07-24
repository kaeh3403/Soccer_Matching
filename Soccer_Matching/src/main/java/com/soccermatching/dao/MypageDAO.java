package com.soccermatching.dao;

import java.util.List;

import com.soccermatching.dto.MatchBoardDTO;

public interface MypageDAO {
	
	public List<MatchBoardDTO> ApplyList(int number);
	
	public List<MatchBoardDTO> RegisterList(int number);
}
