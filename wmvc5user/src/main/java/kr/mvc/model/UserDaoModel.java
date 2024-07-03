package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.mvc.controller.UserForm;

//Controller 클래스의 요청을 받아 DB 연동 처리 담당
public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public UserDaoModel() {

	}

	public UserDto findUser(String userid) {
		UserDto dto = null;

		SqlSession session = factory.openSession();
		try {
			dto = session.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser error : " + e);
		} finally {
			session.close();
		}

		return dto;
	}

	public ArrayList<UserDto> getUserDataAll() {
		List<UserDto> list = null; // mybatis는 List를 반환

		SqlSession session = factory.openSession();
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserAll error : " + e);
		} finally {
			session.close();
		}

		return (ArrayList<UserDto>) list; // 따라서 ArrayList로 캐스팅해줘야
	}

	public int insertData(UserForm userForm) {
		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.insert("insertData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData error : " + e);
			session.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	public int updatetData(UserForm userForm) {
		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.insert("updateData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("updatetData error : " + e);
			session.rollback();
		} finally {
			session.close();
		}

		return result;
	}
	
	public int deleteData(String userid) {
		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.insert("deleteData", userid);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteData error : " + e);
			session.rollback();
		} finally {
			session.close();
		}

		return result;
	}
}
