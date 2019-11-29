package memvo;

import java.sql.Date;

public class MEMBERVO {
	private int member_id_uk;
	private int member_no_number;
	private String mem_id_nn;
	private String mem_pw_nn;
	private String grade;
	public int getMember_id_uk() {
		return member_id_uk;
	}
	public void setMember_id_uk(int member_id_uk) {
		this.member_id_uk = member_id_uk;
	}
	public int getMember_no_number() {
		return member_no_number;
	}
	public void setMember_no_number(int member_no_number) {
		this.member_no_number = member_no_number;
	}
	public String getMem_id_nn() {
		return mem_id_nn;
	}
	public void setMem_id_nn(String mem_id_nn) {
		this.mem_id_nn = mem_id_nn;
	}
	public String getMem_pw_nn() {
		return mem_pw_nn;
	}
	public void setMem_pw_nn(String mem_pw_nn) {
		this.mem_pw_nn = mem_pw_nn;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public MEMBERVO() {
		
	}
	public MEMBERVO(int member_id_uk, int member_no_number, String mem_id_nn, String mem_pw_nn, String grade) {
		super();
		this.member_id_uk = member_id_uk;
		this.member_no_number = member_no_number;
		this.mem_id_nn = mem_id_nn;
		this.mem_pw_nn = mem_pw_nn;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "MEMBERVO [member_id_uk=" + member_id_uk + ", member_no_number=" + member_no_number + ", mem_id_nn="
				+ mem_id_nn + ", mem_pw_nn=" + mem_pw_nn + ", grade=" + grade + "]";
	}
	
	
}
