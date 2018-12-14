package package01;

import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Select_Person extends JdbcDaoSupport {
		@SuppressWarnings("rawtypes")
		public List getallInfo(String name) {
			name="'"+name+"'";
			String sql;
			sql="select Person.name,Person.sex,Person.ID_card,roomInfo.ID from Person,roomInfo where Person.name=roomInfo.name and Person.name="+name;
			List Info=getJdbcTemplate().queryForList(sql);
			return Info;
		} 
	
}
