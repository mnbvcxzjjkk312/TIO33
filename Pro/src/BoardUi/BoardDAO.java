package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

<<<<<<< HEAD


public class BoardDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<BoardVO> clickContent(int type)
	{
		try
		{
			con = DBConnection.getCon();
			
			String sql = "select boardnum, title, content from board where boardnum = ?";
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
	
	// 리스트 창에서 글 목록을 생성해 주는 메서드.
	public ArrayList<BoardVO> makeList()
	{
		try
		{
			con = DBConnection.getCon();
			String sql = "select boardnum, title, content, id, wdate from board";
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
	
	// DB에서 ROW를 가져오는 메서드.
	public ArrayList<BoardVO> getList(ResultSet rs) throws SQLException
	{
		ArrayList<BoardVO> bvoArr = new ArrayList();
		while(rs.next())
		{
			BoardVO bvoTemp = new BoardVO(rs.getInt("Boardnum"), rs.getString("title"), rs.getString("content"), rs.getString("id"), rs.getDate("wdate"));
			bvoArr.add(bvoTemp);
		}
		return bvoArr;
	}

	// 글 목록에서 글을 선택하면 본문이 열리는 메서드.
	// 필요없는 메서드.
	public int selectTopic()
	{
		try
		{
			//int row = bl.jTable1.getSelectRow();
			//Object objBoardnum = jTalbe1.getValueAt(row, 0);
			//Integer Boardnum = (Integer) objBoardnum;
		} 
		catch (Exception e)
		{
			
		}
		return 0;
	}
	
	
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
=======
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
	
>>>>>>> refs/heads/KDH_B1
}
