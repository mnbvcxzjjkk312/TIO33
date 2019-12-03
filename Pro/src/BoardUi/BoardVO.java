package BoardUi;

<<<<<<< HEAD
import java.sql.Date;

public class BoardVO
{
	private int boardnum;
	private String title;
	private String content;
	private String id;
	private java.sql.Date wdate;
	
	public BoardVO()
	{
		this(0, null, null, null, null);
	}

	public BoardVO(int boardnum, String title, String content, String id, Date wdate)
	{
		super();
		this.boardnum = boardnum;
		this.title = title;
		this.content = content;
		this.id = id;
		this.wdate = wdate;
	}

	public int getBoardnum()
	{
		return boardnum;
	}

	public void setBoardnum(int boardnum)
	{
		boardnum = boardnum;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public java.sql.Date getWdate()
	{
		return wdate;
	}

	public void setWdate(java.sql.Date wdate)
	{
		this.wdate = wdate;
	}
	
	@Override
	public String toString()
	{
		return "BoardVO [boardnum =" + boardnum + ", title =" + title + ", content = " + content + ", id =" + id + ", wdate =" + wdate + "]"; 
	}
}
=======
public class BoardVO {
	private int idx;//글번호
	private String id;//작성자
	private String pw;//메모내용
	private int gr;//작성일
	
	//기본생성자, 인자생성자 => 오버로드
	
	public BoardVO() {
		this(0, null, null, 0);
	}

	public BoardVO(int idx, String id, String pw, int gr) {
		super();
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.gr = gr;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getGr() {
		return gr;
	}

	public void setWGr(int gr) {
		this.gr = gr;
	}

	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", id=" + id + ", pw=" + pw + ","
				+ " gr=" + gr + "]";
	}
	
	
}/////////////////////////////////////////////

>>>>>>> refs/heads/KDH_B1
