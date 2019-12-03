package replyvo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class ReplyDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public ArrayList<ReplyVO> listReply(){
		try {
			con=DBUtil.getCon();
			String sql="SELECT idx,r_content,r_wdate,id FROM reply ORDER BY 1 DESC";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<ReplyVO> arr=makeList(rs);
			return arr;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}

	public ArrayList<ReplyVO> makeList(ResultSet rs)
			throws SQLException{
				ArrayList<ReplyVO> arr=new ArrayList<>();
				while(rs.next()) {
					int idx=rs.getInt("idx");
					String r_content=rs.getString("r_content");
					java.sql.Date r_wdate=rs.getDate("r_wdate");
					String id=rs.getString("id");
					ReplyVO vo=new ReplyVO(idx,r_content,r_wdate,id);
					arr.add(vo);
				}////while-----------------------
				return arr;
				
			}
	
	
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
