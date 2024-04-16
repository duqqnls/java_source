package pack1;

public class Ex1Main {  // 응용 프로그램의 시작, 즉 main을 위한 클래스일 뿐,
	public static void main(String[] args) {
		 System.out.println("이런 저런 작업을 하다가..");
		 int a = 1;
		 System.out.println("기본형 변수 a가 기억한 값:" + a);
		 System.out.println();
		 //자동차 객체를 만들고 싶어..
		 Ex1Car car1 = new Ex1Car (); // 클래스 --> 인스턴스화 --> 인스턴스(객체)
		 // Ex1Car : 보조기억장치에 있는 Ex1.Car.Class를 주기억장치로
		 // car1 : 객체 변수 - 객체의 주소를 기억
		 // new : 인스턴스화를 키워드
		 // Ex1Car() : 생성자를 호출
		 System.out.println("Ex1Car 타입의 생성된 객체 주소: " + car1); // car1은 정보를 갖고있는게 아닌, 주소를 갖고있는거임
		 System.out.println("바퀴 수 : " + car1.wheel);
		 car1.abc();
		 // car1.def(); // private 이므로 호출 불가
		 
		 System.out.println("객체 하나 더 생성 !");
		 Ex1Car car2 = new Ex1Car();
		 System.out.println("Ex1Car 타입의 생성된 객체 주소: " + car2);
		 System.out.println("def def 메소드 수행");
		
		 
		 
		 
	}

}
