package pack1;

public class Ex2Car {
	private int speed;
	public String irum;
	private double weight;
	// 	private double weight = 0.0; 같은 의미 
	public Ex2Car() {
		irum = "홍길동";
		speed = 10;
	}
	
	public void showData() {
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}

/*	 public void abcd(int s, int password) { // private 멤버값을 외부에서 접근하기 위한 메소드
	 if (password == 123) { 
		speed = s; // s는 speed의 값을 받기 위함 
		}
	}
}*/
	
	public void setSpeed(int s) { //speed에만 집중. -setter 메소드
		speed = s;
	}
	
	public int getSpeed() { // 값을 참조할 거야 -getter 메소드 
		return speed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight; //지역변수 weight 멤버필드 weight와 이름이 같다면, 구분해야한다. ->this를 붙여준다ight와 이름이 같다면, 구분해야한다. ->this를 붙여준다
		// 멤버필드 weight에 지역변수 weight값을 치환한다.
		
	}
	
}
