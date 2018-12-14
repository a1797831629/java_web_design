package package01;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Select_all extends JdbcDaoSupport {
	
	@SuppressWarnings("rawtypes")
	public List getallInfo(String type) {
		String sql;
		type="'"+type+"'";
		sql="select ID,context,price from roomInfo where status='0' and context="+type;
		List Info=getJdbcTemplate().queryForList(sql);
		return Info;
	} 
}
//这里应该传递参数