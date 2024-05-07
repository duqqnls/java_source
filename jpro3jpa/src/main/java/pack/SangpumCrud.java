package pack;

import java.util.List;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

import ch.qos.logback.core.subst.Token.Type;
import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangpumCrud {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : thread 단위로 작업 
	 	EntityManager em = emf.createEntityManager();
	 	EntityTransaction transaction = em.getTransaction(); // 트랙잭션 목적 
	 	
	 	// 자료 추가
	 	/*
	 	try {
			transaction.begin();
			SangpumTable sangtab = new SangpumTable(5, "도시락", 3, 6000);
			em.persist(sangtab);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("insert err: " + e);
			transaction.rollback();
			return;
		}
		*/
	 	
	 	// 자료 수정 
	 	/*
	 	try {
			transaction.begin();
			SangpumTable sangtab = em.find(SangpumTable.class, "5"); //수정할 대상인 "5"를 읽고
			if(sangtab == null) { // 비어있다면 -- * 1
				System.out.println("해당 자료 없음"); // 을 출력하고 
			} else { // 비어있지 않다면 -- * 2 
				String newName = "마스크"; // 이름을 바꾸고
				sangtab.setSang(newName); // setsang이 뭐냐
				transaction.commit(); // 커밋해준다.
			}
		} catch (Exception e) {
			System.out.println("update err: " + e);
			transaction.rollback();
			return;
		}
		*/
	 	
	 	// 자료 삭제 
	 	try {
			transaction.begin();
			
			int findCode = 5; // 지울 대상 5번을 읽어야 한다.
			SangpumTable sangtab = em.find(SangpumTable.class, findCode);
			if(sangtab == null) { 
				System.out.println("해당 자료 없음");  
				transaction.rollback();
			} else {
				em.remove(sangtab);
				System.out.printf("자료 삭제됨 : %s", findCode);
				transaction.commit(); // 커밋해준다.
			}
			
		} catch (Exception e) {
			System.out.println("delete err: " + e);
			transaction.rollback();
			return;
		}
	 	
		// JPA를 사용한 DML 처리
		try {
			System.out.println("전체 자료 읽기1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작점을 의미하는 Root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
					
			for(SangpumTable st:resultList) { 
				System.out.println(st.getCode() + " " + st.getSang() + " " +
			st.getSu()+ " " + st.getDan());
			}
			
			System.out.println("\n전체 자료 읽기2");
			// TypedQuery를 이용해 JPQL 사용
			/* ^_^1번
			TypedQuery<SangpumTable> queryql = em.createQuery("select s from SangpumTable s", SangpumTable.class); // 문법임..-__-^
			List<SangpumTable> list = queryql.getResultList();
			*/
			// 위 두줄을 한 줄로 표현 ^_^2번
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			
			for(SangpumTable st:list) { 
				System.out.println(st.getCode() + " " + st.getSang() + " " +
			st.getSu()+ " " + st.getDan());
			}
			
			System.out.println("\n부분 자료 읽기1");
			int findId = 1; // String findId = "1"; 도 상관없다  -> pk 칼럼이 대상 , 아무나 못 들어옴 ;;;
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else { 
				System.out.printf("%s %s %s %s\n", sangtab.getCode(), sangtab.getSang(), sangtab.getSu(), sangtab.getDan());
			}
			
			System.out.println("\n부분 자료 읽기2"); // 찾는 대상이 pk가 아닌 경우
			TypedQuery<SangpumTable> typeQuery = em.createQuery(
					query.where(cb.equal(root.get("sang"), "장갑")));
			List<SangpumTable> resultList2 = typeQuery.getResultList();
			
			for(SangpumTable sangtab2:resultList2) {
				System.out.printf("%s %s %s %s\n", sangtab2.getCode(), sangtab2.getSang(),sangtab2.getSu(), sangtab2.getDan());
			}
			
			System.out.println("\n부분 자료 읽기2");
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close(); // 필수다잉 
		}

	}

}
