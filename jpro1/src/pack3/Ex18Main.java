package pack3;

public class Ex18Main {

	public static void main(String[] args) {
		Ex18Cow cow = new Ex18Cow();
		System.out.println(cow.name());
		System.out.println(cow.eat());
		System.out.println(cow.action());
		cow.animalPrint();
		
		System.out.println();
		Ex18Lion lion = new Ex18Lion();
		System.out.println(lion.name());
		System.out.println(lion.eat());
		System.out.println(lion.action());
		lion.animalPrint();
		lion.eatOther(); 
		
		System.out.println();
		Ex18Animal animal; // 도 되고 Ex18Animal animal = null; 같은 말 
		animal = cow;
		System.out.println(animal.name());
		animal = lion;
		System.out.println(animal.name());
		
		System.out.println("\n별도의 클래스 사용해 보기");
		Ex18FindUtil.find(cow);
		System.out.println();
		Ex18FindUtil.find(lion);
	
	}

}
