package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import memvo.MEMBERVO;
//import boardvo.BoardVO;


public class BoardDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
//	public int insertMember(MEMBERVO board) {
//		try {
//			con=DBUtil.getCon();
//			String sql= "insert into member values(board_seq.nextval,?,?,?,?)";
//			ps=con.prepareStatement(sql);
//			ps.setString(1, board.getId());
//			ps.setString(2, board.getPw());
//			ps.setString(3, board.getName());
//			ps.setInt(4, board.getGr());
//			int n = ps.executeUpdate();
//			return n;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return -1;
//		}finally {
//			close();
//		}
//	}//--------------------------------------
	
	
	
	
	//�α��� �޼ҵ�
//	public ArrayList<BoardVO> Login(){
//		try {
//			con=DBUtil.getCon();
//			String calId = "";
//			String sql = "SELECT member_no, id, password, name, grade FROM board ORDER BY 1 asc";
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			ArrayList<BoardVO> arr = makeList(rs);
//			return arr;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			close();
//		}
//	}

	
	//���带 ����� �޼ҵ�
//	public ArrayList<BoardVO> AddBoard(BoardVO board){
//		try {
//			con=DBUtil.getCon();
//			String sql = "INSERT INTO BOARD VALUES(board_seq.nextval,?,?,?,SYSDATE)";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, board.getTitle());
//			ps.setString(2, board.getContent());
//			ps.setString(3, board.getId());
//			int n = ps.executeUpdate();
//			return n;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			close();
//		}
//	}
	
	// ����� Ŭ���ϸ� ������ �����ִ� �޼���.
	public ArrayList<BoardVO> clickContent(int type)
	{
		try
		{
			con = DBConnection.getCon();
			
			String sql = "insert into board values(board_seq.nextval,?,?,?,?)";
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
	
	// ����Ʈ â���� �� ����� ������ �ִ� �޼���.
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
	
	// DB���� ROW�� �������� �޼���.
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

	// �� ��Ͽ��� ���� �����ϸ� ������ ������ �޼���.
	// �ʿ���� �޼���.
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
	
	
	// �� �������� ���� ����� �޼���.
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
	
	// �� �������� ���� �����ϴ� �޼���.
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
	
	
	// DB���� ������ �����ϴ� �޼���.
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
