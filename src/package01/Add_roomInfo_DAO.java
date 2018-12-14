package package01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Add_roomInfo_DAO {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@SuppressWarnings("resource")
	public void addInfo(RoomInfo roomInfo,Person person) {
		String status=roomInfo.getStatus();
		String name=roomInfo.getName();
		String sex=person.getSex();
		String ID_card=person.getID_card();
		int room_ID=roomInfo.getID();
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=dataSource.getConnection();
			String strsql="insert into Person(name,sex,ID_card) values(?,?,?)";
			pStatement=connection.prepareStatement(strsql);
			pStatement.setString(1, name);
			pStatement.setString(2, sex);
			pStatement.setString(3, ID_card);
			pStatement.executeUpdate();
			
			
			strsql="update roomInfo set status=?,name=? where ID=?";
			pStatement=connection.prepareStatement(strsql);
			pStatement.setString(1, status);
			pStatement.setString(2, name);
			pStatement.setInt(3, room_ID);
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			if (pStatement!=null) {
				try {
					pStatement.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		}
		
	}

}
