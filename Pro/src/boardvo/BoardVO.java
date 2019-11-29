package boardvo;

public class BoardVO {
	private int boardnum;
	private String title;
	private String content;
	private String id;
	private String wdate;
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public BoardVO() {
		
	}
	public BoardVO(int boardnum, String title, String content, String id, String wdate) {
		super();
		this.boardnum = boardnum;
		this.title = title;
		this.content = content;
		this.id = id;
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "BoardVO [boardnum=" + boardnum + ", title=" + title + ", content=" + content + ", id=" + id + ", wdate="
				+ wdate + "]";
	}
	
	
	
}

