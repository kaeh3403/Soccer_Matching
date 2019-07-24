package com.soccermatching.dao;

import java.util.List;

import com.soccermatching.dto.MatchBoardDTO;

public interface MatchApplyDAO {
	public List<MatchBoardDTO> readAppliedMatch(int memberNumber);
}
