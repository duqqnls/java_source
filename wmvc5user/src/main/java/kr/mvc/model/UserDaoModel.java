package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

// Controller 클래스의 요청을 받아 DB 연동 처리 담당 
public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		
		SqlSession session = factory.openSession();
	
		try {
			dto = session.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser err " + e);
		} finally {
			session.close();
		}
		return dto;
	}
	
	public ArrayList<UserDto> getUserAll() {
		List<UserDto> list = null;
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserAll err " + e);
		} finally {
			session.close();
		}
		
		return (ArrayList<UserDto>)list;
	}
}
