package pack1;

// 접근 지정자 
// - public : 같은 프로젝트 내에서 유효. 패키지가 달라도 됨
// - protected : 같은 프로젝트 내에서 유효. 패키지가 다른 경우 자식클래스만 유효
// - default : 같은 패키지 내에서만 유효
// - private : 현재 클래스 내에서만 유효 다른 클래스에서는 참조 불가

public class Ex1Car { // [접근지정자][기타제한자] class 클래스명 그리고 첫 글자는 대문자
	int wheel;	// 멤버 필드 (전역 변수) : defalut 접근 지정자
	private int airBag = 1; // [접근지정자][기타제한자] 타입 변수명 
	private int speed;      //  private하고 주변 캡슐화 = 외부에서 접근하지 못하도록 캡슐화
	public String irum; 
	
	public Ex1Car() { // 클래스와 이름이 같고 반환형이 없는 메소드 : 생성자(Constructor)
		System.out.println("생성자 : 객체 생성시 초기화를 담당. 1회 호출됨.");
		wheel = 4;
	}
	
	public void abc() { // [접근지정자][기타제한자] 반환타입(형) 메소드명([타입 매개변수..])
		System.out.println("abc 메소드 수행");
		System.out.println("Ex1Car 타입의 생성된 객체 주소 car1");
		def();
	}
	public void def() {
		System.out.println("def 메소드 수행");
	}
}
