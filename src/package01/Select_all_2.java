package package01;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Select_all_2 extends JdbcDaoSupport {
	
	@SuppressWarnings("rawtypes")
	public List getallInfo() {
		String sql;
		sql="select roomInfo.ID,roomInfo.context,roomInfo.price,roomInfo.status,Person.name,Person.sex,Person.ID_card from Person,roomInfo where Person.name=roomInfo.name";
		List Info=getJdbcTemplate().queryForList(sql);
		return Info;
	} 
}