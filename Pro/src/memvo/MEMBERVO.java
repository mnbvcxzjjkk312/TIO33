package memvo;

import java.sql.Date;

public class MEMBERVO {
	
	private int member_no;
	private String id;
	private String password;
	private String name;
	private int grade;

	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public MEMBERVO() {
		
	}
	public MEMBERVO(int member_no, String id, String password, String name, int grade) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
	}
	
	public MEMBERVO(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "MEMBERVO [member_no=" + member_no + ", id=" + id + ", password="
				+ password + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
}
