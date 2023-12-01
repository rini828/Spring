package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

/**
 *	mysql데이터베이스 연결을 테스트하기위한 클래스
 */
public class MysqlConnectTest {
	
	// 디비연결 정보
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String DBURL ="jdbc:mysql://localhost:3306/springdb";
	private static final String DBID ="root";
	private static final String DBPW ="1234";
	
	// @Test : 테스트 하고자하는 내용을 메서드 안에 작성후 
	//         해당 어노테이션을 작성하면, Junit이 해당코드를
	//         테스트용 코드로 인식하고 자동 실행 및 테스트 진행
	@Test
	public void testConnection() {
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			System.out.println(" 드라이버 로드 성공! ");
			// 2. 디비 연결
			Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
			System.out.println(" 디비연결 성공! ");
			System.out.println(" con : "+con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(" 자원해제 코드 작성 ");
		}
		
		
		// try-with(1.7~ 사용) => try,catch,finally 한번에 처리하는 동작
		// =>AutoCloseable 인터페이스를 구현한 객체를 try()안에 작성하면
		//  사용후 자동으로 자원해제 처리 
		try(Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);) {
			System.out.println(" 디비연결 성공2! ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
