package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

// @AllArgsConstructor 생성자 다 포함
// @ToString
// @Getter - F4 겟만
@Data
public class MemberVO {
	// Value Object => DTO 개념으로 사용 (디비 테이블정보를 저장하는 객체)
	
	// tbl_member 테이블의 정보를 저장
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	
//	private String uAbc; - 컬럼명으로 나쁘다 롬복이 getUAbc 주고 el 표현식은 uAbc 달라해서 엇갈림
	
}
