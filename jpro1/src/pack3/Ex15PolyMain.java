package pack3;

public class Ex15PolyMain {

	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		
		System.out.println("\n-- 객체 주소 치환 --");
		Ex15PolyCar car2 = new Ex15PolyBus(); // 자식객체를 부모객체에게 상속이 가능하다.
		car2.displaySpeed(); // 부모로부터 상속받은 오버라이딩(메소드)이기 때문에 접근 가능 
		System.out.println(car2.getSpeed());
//		car2.show(); // 오버라이딩이 아니라면, 접근 불가능!! 규칙 ! 약속 ;; ;  자식 고유의 메소드는 간섭(호출) 불가능 
		
		System.out.println();
		Ex15PolyCar car3 = taxi1;// Promotion 
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		car3.displaySpeed();
		System.out.println(car3.getSpeed());
		
		System.out.println("\n======");
//		Ex15PolyBus bus2 = new Ex15PolyCar(); // 부모 클래스를 자식 클래스에 타입 미스 
		Ex15PolyBus bus3 = (Ex15PolyBus)car2; // 타입 미스 car2는 부모클래스임(polycar) 그러니까 강제타입 변환해주면 됌 = Casting 
		// car2는 부모 타입이지만 bus의 주소를 갖고 있으므로 캐스팅에 의해 치환 가능 
		bus3.displaySpeed();
		
		System.out.println();
		// Ex15PolyTaxi taxi2 = new Ex15PolyCar(); -> 타입 미스 
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi)car3; // casting 성립완료
		taxi2.displaySpeed();
		
//		Ex15PolyTaxi taxi3 = (Ex15PolyTaxi)car1; // 문제는 아닌데 런타임에러(실행오류) 발생 why? car1은 taxi3과 메모리 주소가 다르기 때문 
		
		System.out.println("\n====== 다형성");
		Ex15PolyCar mycar;
		mycar = bus1;
		mycar.displaySpeed();
		
		mycar = taxi1;
		mycar.displaySpeed();
		
		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		for (Ex15PolyCar poly:p) { // 변수 poly의 p를 하나씩 뽑아서 displayspeed를 실행한 결과를 보여준다 ! 
			poly.displaySpeed();
		}	
	}
}
