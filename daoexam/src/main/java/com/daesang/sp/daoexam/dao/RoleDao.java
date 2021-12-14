package com.daesang.sp.daoexam.dao;

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

import com.daesang.sp.daoexam.dto.Role;
import static com.daesang.sp.daoexam.dao.RoleDaoSqls.SELECT_ALL;
import static com.daesang.sp.daoexam.dao.RoleDaoSqls.UPDATE;
import static com.daesang.sp.daoexam.dao.RoleDaoSqls.SELECT_BY_ROLE_ID;
import static com.daesang.sp.daoexam.dao.RoleDaoSqls.DELETE_BY_ROLE_ID;

@Repository
public class RoleDao {
	private final NamedParameterJdbcTemplate jdbc;
	private final SimpleJdbcInsert insertAction;
	private final RowMapper<Role> rowMapper;
	
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
		this.rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	}
	
	public List<Role> selectAll() {
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	public int deleteByRoleId(int roleId) {
		Map<String, ?> params = Collections.singletonMap("roleId ", roleId);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectByRoleId(int roleId) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", roleId);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
