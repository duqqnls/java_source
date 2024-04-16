package pack3;

public class Ex14Main {
	public static void main(String[] args) {
		// 개과의 동물들 상속으로 처리
		Ex14Dog dog = new Ex14Dog();
		dog.printMsg();
		System.out.println(dog.callName());
		
		System.out.println("HouseDog ------");
		Ex14HouseDog hd = new Ex14HouseDog("집개");
		hd.printMsg();
		System.out.println(hd.callName());
		
		System.out.println("wolfDog ------");
		Ex14wolfDog wolfDog = new Ex14wolfDog("늑대");
		wolfDog.printMsg();
		System.out.println(wolfDog.callName());
		System.out.println();
		wolfDog.display();
		
		System.out.println("\n\n주소 치환 ------");
		Ex14wolfDog bushDog = wolfDog; // 같은 타입의 변수에게 주소를 치환 (bushdog에는 wolfdog주소를 가지고 있음)
		wolfDog.printMsg();
		bushDog.printMsg();
		
		System.out.println();
		// Ex14HouseDog hd2 = wolfDog; // Type mismatch 에러 
		Ex14Dog dog2 = wolfDog; // 타입은 다르지만, 부모변수에 자식변수 주소 치환 가능하다. //왜 dog2가 부모변수 객체냐 
		dog2.printMsg();
		
		Ex14Dog dog3 = new Ex14Dog();
		dog3.printMsg();
//		Ex14wolfDog wolfDog2 = dog3; // 자식 객체변수에 부모 변수 주소 치환은 불가능 
//		wolfDog = dog3;
		
	}

}
