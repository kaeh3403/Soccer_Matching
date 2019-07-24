package com.soccermatching.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soccermatching.dto.MatchApplyDTO;
import com.soccermatching.dto.MatchBoardDTO;

@Repository
public class MatchApplyDAOImpl implements MatchApplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MatchBoardDTO> readAppliedMatch(int memberNumber) {
		return jdbcTemplate.query(
				"SELECT number, author, address, detail_address,place_name,date, start_time,start_time_minutes, end_time, end_time_minutes, game_type, gender, number_appliable, detail_info,x,y, register_date from match_board mb, match_apply ma where ma.match_board_number = mb.number and member_number = ?",
				new MatchBoardDTOMapper(), memberNumber);
	}

	public final class MatchApplyDTOMapper implements RowMapper<MatchApplyDTO> {
		public MatchApplyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchApplyDTO matchApplyDTO = new MatchApplyDTO();
			matchApplyDTO.setMatchBoardNumber(rs.getInt("match_board_number"));
			matchApplyDTO.setMemberNumber(rs.getInt("member_number"));

			return matchApplyDTO;
		}
	}

}
