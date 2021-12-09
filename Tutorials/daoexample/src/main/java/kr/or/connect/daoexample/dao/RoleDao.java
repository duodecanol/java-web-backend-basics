package kr.or.connect.daoexample.dao;

// RoleDaoSqls: QUERY
import static kr.or.connect.daoexample.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexample.dto.Role;


@Repository
public class RoleDao { // ==> DataSource
	// SimpleJdbcInsert
	
	// NamedParameterJdbcTemplate
	//   + query()           : List<Object>
	//   + queryForObject()  : Object
	//   + update()          : int
	private NamedParameterJdbcTemplate jdbc;
	
	private SimpleJdbcInsert insertAction;
	
	// Column values are mapped based on matching the column name as obtained from result set
	// metadata to public setters for the corresponding properties.
	// The names are matched either directly or by transforming a name separating the parts with 
	// underscores to the same name using "camel" case. 
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("role");
	}
	
	public List<Role> selectAll() {
		/*
		 * Type Parameters:<T> 
		 * Parameters:
		 * 		sql  = SQL query to executeparamMap map of parameters to bind to the 
		 * 		query  = (leaving it to the PreparedStatement to guess the corresponding SQL type)
		 * 		rowMapper  = object that will map one object per rowReturns:the result List, containing mapped objects
		 * */
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params); // from SimpleJdbcInsert	
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}	
}
