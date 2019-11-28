package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertUser(BoardVO user) {
		try {
			con=DBUtil.getCon();
			String sql= "insert into memo values(user_seq.nextval,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setInt(3, user.getGr());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//오류 발생시는 음수를 반환
		}finally {
			close();
		}
	}//--------------------------------------
	
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
