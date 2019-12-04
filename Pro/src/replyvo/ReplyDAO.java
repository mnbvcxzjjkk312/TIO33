package replyvo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BoardUi.DBConnection.*;
import BoardUi.DBConnection;



public class ReplyDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	// ���� ����� �����ϴ� �޼���.
	// 12.04 �߰��� �ڵ�. �Ű������� boardNum�� �����ͼ� �ش� �ۿ����� ������ ���̰� ��.
	public ArrayList<ReplyVO> listReply(int boardNum){
		try {
			con=DBConnection.getCon();
			String sql="SELECT idx,r_content,r_wdate,id, boardNum FROM reply where boardNum = ? ORDER BY 1 DESC";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, boardNum);
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

	// DB���� ROW�� �������� �޼���.
	public ArrayList<ReplyVO> makeList(ResultSet rs)
			throws SQLException{
				ArrayList<ReplyVO> arr=new ArrayList<>();
				while(rs.next()) {
					int idx=rs.getInt("idx");
					String r_content=rs.getString("r_content");
					java.sql.Date r_wdate=rs.getDate("r_wdate");
					String id=rs.getString("id");
					//12.04 �߰��� �ڵ�. �۹�ȣ �߰�.
					int boardNum=rs.getInt("boardNum");
					ReplyVO vo=new ReplyVO(idx,r_content,r_wdate,id, boardNum);
					arr.add(vo);
				}////while-----------------------
				return arr;
				
			}
	
	// ������ ����ϴ� �޼���.
	public int insertMsg(ReplyVO reply) {
		try {
			con=DBConnection.getCon();
			String sql="insert into REPLY values(SEQ_REPLY.nextval,?,sysdate,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,reply.getR_content());
			ps.setString(2,reply.getId());
			// 12.04 �߰��� �ڵ�. ���ÿ� �۹�ȣ�� �߰��Ͽ� �ش� �ۿ����� ������ ���̵��� ��.
			ps.setInt(3,reply.getBoardNum());
			int n=ps.executeUpdate();
			return n;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}
	
	// DB���� ������ �����ϴ� �޼���.
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			
		}
	}
}
