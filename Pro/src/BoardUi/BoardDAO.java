package BoardUi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	// ����Ʈ â���� �� ����� ������ �ִ� �޼���.
	public ArrayList<BoardVO> makeList()
	{
		try
		{
			con = DBConnection.getCon();
			String sql = "select Boardnum, title, content, id wdate";
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
	public int selectTopic()
	{
		try
		{
			int row = bl.jTable1.getSelectRow();
			
			Object objBoardnum = jTalbe1.getValueAt(row, 0);
			Integer Boardnum = (Integer) objBoardnum;
		} 
		catch (Exception e)
		{
			
		}
		return 0;
	}
	
	
	// �� ��Ͽ��� ���� ����� �޼���.
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
