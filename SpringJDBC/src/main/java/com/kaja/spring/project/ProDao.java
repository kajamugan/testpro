package com.kaja.spring.project;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int savePro(Project p) {
		String query = "INSERT INTO projects (project_name,project_description) VALUES ('"+p.getProjName()+"','"+p.getProjDescription()+"')";
		return jdbcTemplate.update(query);
	}
}
