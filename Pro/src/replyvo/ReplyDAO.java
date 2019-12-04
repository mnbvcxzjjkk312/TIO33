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
	
	// 리플 목록을 생성하는 메서드.
	// 12.04 추가한 코드. 매개변수로 boardNum을 가져와서 해당 글에서만 리플이 보이게 함.
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

	// DB에서 ROW를 가져오는 메서드.
	public ArrayList<ReplyVO> makeList(ResultSet rs)
			throws SQLException{
				ArrayList<ReplyVO> arr=new ArrayList<>();
				while(rs.next()) {
					int idx=rs.getInt("idx");
					String r_content=rs.getString("r_content");
					java.sql.Date r_wdate=rs.getDate("r_wdate");
					String id=rs.getString("id");
					//12.04 추가한 코드. 글번호 추가.
					int boardNum=rs.getInt("boardNum");
					ReplyVO vo=new ReplyVO(idx,r_content,r_wdate,id, boardNum);
					arr.add(vo);
				}////while-----------------------
				return arr;
				
			}
	
	// 리플을 등록하는 메서드.
	public int insertMsg(ReplyVO reply) {
		try {
			con=DBConnection.getCon();
			String sql="insert into REPLY values(SEQ_REPLY.nextval,?,sysdate,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,reply.getR_content());
			ps.setString(2,reply.getId());
			// 12.04 추가한 코드. 리플에 글번호를 추가하여 해당 글에서만 리플이 보이도록 함.
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
	
	// DB로의 접속을 종료하는 메서드.
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			
		}
	}
}
