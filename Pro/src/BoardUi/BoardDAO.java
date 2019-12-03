package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertUser(UserVO user) {
		try {
			con=DBUtil.getCon();
			String sql= "insert into user values(user_seq.nextval,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setInt(3, user.getGr());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}//--------------------------------------
	
	public ArrayList<UserVO> Login(){
		try {
			con=DBUtil.getCon();
			String calId = "";
			String sql = "SELECT idx, id, pw, gr FROM user ORDER BY 1 asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<UserVO> arr = makeList(rs);
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
	public ArrayList<UserVO> makeList(ResultSet rs)
	throws SQLException{
		ArrayList<UserVO> arr = new ArrayList<>();
		while(rs.next()) {
			int idx = rs.getInt("id");
			String name = rs.getString("pw");
			String msg = rs.getString("msg");
			int gr = rs.getInt("gr");
			UserVO voTemp = new UserVO(idx, name, msg, gr);
			arr.add(voTemp);
		}//while---------------------
		return arr;
	}
	
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {}
	}
	
}
