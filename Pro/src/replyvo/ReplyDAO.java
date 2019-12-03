package replyvo;
import java.sql.*;

public class ReplyDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertMsg(ReplyVO reply) {
		try {
			con=DBUtil.getCon();
			String sql="insert into REPLY values(SEQ_REPLY.nextval,?,sysdate,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,reply.getR_content());
			ps.setString(2,reply.getId());
			int n=ps.executeUpdate();
			return n;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			
		}
	}
}
