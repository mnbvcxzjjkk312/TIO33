package BoardUi;

public class BoardVO {
	private int idx;//�۹�ȣ
	private String id;//�ۼ���
	private String pw;//�޸𳻿�
	private int gr;//�ۼ���
	
	//�⺻������, ���ڻ����� => �����ε�
	
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

