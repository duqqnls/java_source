package pack3;

public class Ex13Object extends Object{ // extends Object = 원래 이게 생략되어있는거임
	// public class Ex13Object{ 3번과 똑같은 코드문 
	@Override
	public String toString() {
		// 오버라이딩 : 부모의 본래 기능을 자식이 원하는 명령으로 재정의 
		return "자바여 영원하라";
	}
	
//public class Ex13Object extends Object{ // 원래 이게 생략되어있는거임 !  
	public static void main(String[] args) {
		// 최상위 수퍼 클래스 Object
		// 모든 클래스는 자동으로 Object 클래스를 상속받는다. !진리!
		Ex13Object obj = new Ex13Object();
		System.out.println(obj);
		System.out.println(obj.toString());
	}

}
