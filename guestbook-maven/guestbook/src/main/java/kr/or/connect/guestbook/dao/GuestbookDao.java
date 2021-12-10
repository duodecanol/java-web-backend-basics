package kr.or.connect.guestbook.dao;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.guestbook.dto.Guestbook;

@Repository
public class GuestbookDao {
	private SimpleJdbcInsert insertAction;
	private NamedParameterJdbcTemplate jdbc;
	RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);
	
	// CONSTRUCTOR
	public GuestbookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("visitorbook")
				.usingGeneratedKeyColumns("id");		
	}
	
	public List<Guestbook> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query("SELECT * FROM visitorbook OFFSET ? LIMIT ?", params, rowMapper);		
	}
	
	public Long insert(Guestbook guestbook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update("DELETE FROM visitorbook WHERE id = ?", params);
	}
	
	public int selectCount() {
		return jdbc.queryForObject("SELECT COUNT(*) FROM visitorbook", Collections.emptyMap(), Integer.class);
	}
}

