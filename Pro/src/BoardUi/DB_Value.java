package BoardUi;

public class DB_Value {
	/*
	 * create table MEMBER( 
	 * MEMBER_NO NUMBER(5) CONSTRAINT mem_no_pk primary key, --유저 번호 
	 * ID VARCHAR2(12) CONSTRAINT mem_id_nn NOT NULL, -- 유저 ID
	 * PASSWORD VARCHAR2(12) CONSTRAINT mem_pw_nn NOT NULL, -- 패스워드
	 * NAME VARCHAR2(10),
	 * GRADE NUMBER(1) -- 등급 );
	 * 
	 * CREATE TABLE BOARD( BOARDNUM NUMBER(10) CONSTRAINT
	 * board_num_pk primary key, TITLE varchar2(60), CONTENT VARCHAR2(1500), ID
	 * VARCHAR2(12) CONSTRAINT board_id_fk references member(id) on delete CASCADE,
	 * WDATE TIMESTAMP );
	 * 
	 * CREATE TABLE REPLY( IDX NUMBER(10) CONSTRAINT board_num_fk references
	 * BOARD(BOARDNUM), R_CONTENT CLOB NOT NULL, R_WDATE TIMESTAMP, ID VARCHAR2(12)
	 * CONSTRAINT reply_id_fk references member(id) on delete CASCADE );
	 * 
	 * 
	 */
}
