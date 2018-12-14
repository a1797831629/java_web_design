package package01;

import org.springframework.jdbc.core.JdbcTemplate;

public class Out {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void out(String name) {
		
		
		String sql_d="delete from Person where name="+"'"+name+"'";
		String sql_u="update roomInfo set status='0',name='' where name="+"'"+name+"'";
		jdbcTemplate.update(sql_d);
		jdbcTemplate.update(sql_u);
		
		
	}
}
