package com.soccermatching.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soccermatching.dto.MatchBoardDTO;

@Repository 
public class MypageDAOImpl implements MypageDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MatchBoardDTO> ApplyList(int number) {
		return jdbcTemplate.query("SELECT number, author, address, detail_address,place_name,date, start_time,start_time_minutes, end_time, end_time_minutes, game_type, gender, number_appliable, detail_info,x,y from match_board mb, match_apply ma where ma.match_board_number = mb.number and member_number = ?", new MatchBoardDTOMapper(), number);
	}

	@Override
	public List<MatchBoardDTO> RegisterList(int number) {
		return jdbcTemplate.query("select number, author, address, detail_address,place_name,date, start_time,start_time_minutes, end_time, end_time_minutes, game_type, gender, number_appliable, detail_info,x,y from match_board where author = ? ", new MatchBoardDTOMapper(), number);
	}
	public final class MatchBoardDTOMapper implements RowMapper<MatchBoardDTO> {
		public MatchBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchBoardDTO matchBoardDTO = new MatchBoardDTO();
			
			matchBoardDTO.setAuthor(rs.getInt("author"));
			matchBoardDTO.setDate(rs.getDate("date"));
			matchBoardDTO.setDetailAddress(rs.getString("detail_address"));
			matchBoardDTO.setDetailInfo(rs.getString("detail_info"));
			matchBoardDTO.setEndTime(rs.getString("end_time"));
			matchBoardDTO.setEndTimeMinutes(rs.getString("end_time_minutes"));
			matchBoardDTO.setGameType(rs.getString("game_type"));
			matchBoardDTO.setGender(rs.getString("gender"));
			matchBoardDTO.setNumber(rs.getInt("number"));
			matchBoardDTO.setNumberAppliable(rs.getString("number_appliable"));
			matchBoardDTO.setPlaceName(rs.getString("place_name"));
			matchBoardDTO.setStartTime(rs.getString("start_time"));
			matchBoardDTO.setStartTimeMinutes(rs.getString("start_time_minutes"));
			matchBoardDTO.setX(rs.getString("x"));
			matchBoardDTO.setY(rs.getString("y"));

			return matchBoardDTO;
		}
	}

}
