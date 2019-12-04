package replyvo;

import java.sql.Date;

public class ReplyVO {

	private int idx;
	private String r_content;
	private Date r_wdate;
	private String id;
	private int boardNum;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getR_wdate() {
		return r_wdate;
	}
	public void setR_wdate(Date r_wdate) {
		this.r_wdate = r_wdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ReplyVO() {
		
	}
	public ReplyVO(int idx, String r_content, Date r_wdate, String id, int boardNum) {
		super();
		this.idx = idx;
		this.r_content = r_content;
		this.r_wdate = r_wdate;
		this.id = id;
		this.boardNum = boardNum;
	}
	@Override
	public String toString() {
		return "ReplyVO [idx=" + idx + ", r_content=" + r_content + ", r_wdate=" + r_wdate + ", id=" + id + ", boardNum=" + boardNum + "]";
	}
	public int getBoardNum()
	{
		return boardNum;
	}
	public void setBoardNum(int boardNum)
	{
		this.boardNum = boardNum;
	}
	
	
	
}
