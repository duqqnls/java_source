package pack3;

public class Ex12Father extends Ex12GrandFa{ //단일상속만 가능
	// Ex12GrandFa fa = new Ex12GrandFa(); // 포함 관계 
	
	public String gabo = "꽃병"; //)
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
		super(); //매개변수가 없는 부모 생성자 호출 
		System.out.println("아버지 생성자");
	}
	
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
//	@Override //없어도 되긴 한데, 오버라이딩 하고 있다는 표시 
//	public int getNai() { // method overrideing(오버라이딩) 부모가 가지고 있는 메서드를 자녀도 지님 
//		return nai;
//	}
	
	@Override
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라!";
	}
	
	/*
	final public String getHouse() {  // 메소드에 final를 선언하면, 자식 클래스에서 오버라이딩 불가능이다. 
		return "집 : " + house + "채";
	}
	*/
	public String getHouse() { 
		return "집 : " + house + "채";
	}
	
	public void showData() {
		System.out.println("아버지 나이: " + nai); // 현재 블럭 (지역변수)내에서 nai를 찾고, 없다면 멤버필드 위로 올라간다. 
		System.out.println("아버지 나이: " + this.nai); // 현 클래스의 멤버변수로 간다. 
		System.out.println("아버지 나이: " + getNai()); //현재 클래스에서 getNai변수를 찾다가 없다면, 부모 클래스로 가서 getNai를 찾는다 
		System.out.println("아버지 나이: " + this.getNai()); //(위와같음)현재 클래스에서 getNai를 찾다가 없다면, 부모 클래스로 가서 getNai를 찾는다.
		
		// System.out.println("할아버지 나이: " + super.getNai()); 에러 뜸 
		System.out.println("할아버지 나이: " + super.getNai()); //처음부터 부모 클래스로 가서 getNai를 찾는다.
		
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo); // 물병 
		System.out.println("가보 " + this.gabo); // 꽃병 
		System.out.println("가보 " + super.gabo); // 상감청자 
	}
}
