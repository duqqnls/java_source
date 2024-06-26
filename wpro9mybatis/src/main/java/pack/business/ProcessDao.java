package pack.business;

import java.sql.SQLException; 
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.DataDto;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 세션(하나의 단위 프로그램) 열기 
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		DataDto dto = sqlSession.selectOne("selectDataById", para);
		sqlSession.close();
		return dto;
	}
	
	public void insData(DataForm form) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // transaction 수동 처리 
		sqlSession.insert("insertData", form);
		sqlSession.commit(); // "수동"처리 해줘야함 rollback or commit 
		sqlSession.close();
	}
	
	public void upData(DataForm form) throws SQLException{
		SqlSession sqlSession = factory.openSession(true); // "true"추가시 commit 에서 autocommit 기능됌 
		sqlSession.update("updateData", form);			   // transaction 자동 처리 
		sqlSession.close();
	}
	
	public boolean delData(int para) {
		boolean result = false;		
		SqlSession sqlSession = factory.openSession(); 
		
		try {
			int cou = sqlSession.delete("deleteData", para);
			if(cou > 0) result = true;
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("delData err : " + e);
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return result;	
	}
}