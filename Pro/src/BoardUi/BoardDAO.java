package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import memvo.MEMBERVO;
import boardvo.BoardVO;


public class BoardDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public static String uid;
	String upw;

	
//	// 사용자 추가 메서드
//	public int insertMember(MEMBERVO board) {
//		try {
//			con=DBConnection.getCon();
//			String sql= "insert into member values(member_seq.nextval,?,?,?,?)";
//			ps=con.prepareStatement(sql);
//			ps.setString(1, board.getId());
//			ps.setString(2, board.getPassword());
//			ps.setString(3, board.getName());
//			ps.setInt(4, board.getGrade());
//
//			int n = ps.executeUpdate();
//			return n;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return -1;
//		}finally {
//			close();
//		}
//	}
	
	// 사용자 추가 메서드
	public int insertMember(MEMBERVO member) {
		try {
			con=DBConnection.getCon();
			String sql= "insert into member values(seq_member.nextval,?,?,?,1)";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}//----------------------------------------------		
//////////////////////////////////////////////////////////////////////////////////////////////

	//중복확인 메소드
		public boolean duplicationCheck(String id) {
			try {
				con=DBConnection.getCon();
				String sql= "select count(*) cnt from member where id=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					int cnt =rs.getInt("cnt");
					if(cnt > 0) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return false;
		}
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//로그인하는 메소드
	public void login(String id, String pwd)
	{
		try {
			con=DBConnection.getCon();
			String sql = "SELECT id, password FROM member WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				uid = rs.getString("id");
				upw = rs.getString("password");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} finally 
		{
			close();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////

	//보드에 글을 등록하는 메소드
	public int AddBoard(BoardVO board){
		try {
			ArrayList<BoardVO> ab = null;
			con=DBConnection.getCon();
			String sql = "INSERT INTO BOARD VALUES(seq_board.nextval,?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getId());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// DB에서 ROW를 가져오는 메서드. 
	public ArrayList<MEMBERVO> makeList(ResultSet rs)
	throws SQLException{
		ArrayList<MEMBERVO> arr = new ArrayList<>();
		while(rs.next()) {
			int member_no = rs.getInt("member_no");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			int grade = rs.getInt("grade");
			MEMBERVO voTemp = new MEMBERVO(member_no, id, password, name, grade);
			arr.add(voTemp);
		}//while-------------
		return arr;
	}	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// DB에서 ROW를 가져오는 메서드.
	public ArrayList<BoardVO> getList(ResultSet rs) throws SQLException
	{
		ArrayList<BoardVO> bvoArr = new ArrayList();
		while(rs.next())
		{
			BoardVO bvoTemp = new BoardVO(rs.getInt("boardnum"), rs.getString("title"), rs.getString("content"), rs.getString("id"), rs.getDate("wdate"));
			bvoArr.add(bvoTemp);
		}
		return bvoArr;
	}	
//////////////////////////////////////////////////////////////////////////////////////////////	

	// 리스트 창에서 글 목록을 생성해 주는 메서드.
	public ArrayList<BoardVO> makeList()
	{
		try
		{
			con = DBConnection.getCon();
			String sql = "select boardnum, title, content, id, wdate from board order by boardnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<BoardVO> arr = getList(rs);
			return arr;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			close();
		}
	}	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 목록을 클릭하면 본문을 보여주는 메서드.
	public ArrayList<BoardVO> clickContent(int type)
	{
		try
		{
			con = DBConnection.getCon();
			
			String sql = "select * from board where boardnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, type);
			rs = ps.executeQuery();
			
			ArrayList<BoardVO> arr = getList(rs);
			return arr;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			close();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////

	// 글 본문에서 글을 수정하는 메서드.
	public int update (BoardVO vo)
	{
		try
		{
			con = DBConnection.getCon();
			String sql = "update board set content = '" + vo.getContent() + "' where boardnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBoardnum());
			ps.execute();
			return vo.getBoardnum();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			close();
		}
	}	

//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 글 본문에서 글을 지우는 메서드.
	public int delete(Integer boardnum)
	{
		try
		{
			con = DBConnection.getCon();
			String sql = "delete from board where boardnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardnum);
			ps.execute();
			return boardnum;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			close();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// DB로의 접속을 종료하는 메서드.
	private void close()
	{
		try
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} 
		catch (Exception e)
		{

		}
	}
}
