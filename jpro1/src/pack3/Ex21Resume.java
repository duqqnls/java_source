package pack3;

public interface Ex21Resume { // 이력서 표준 양식 = 인터페이스 내에 선언한 내용은 final임 수정 불가능 
	String SIZE = "A4"; // public final static String SIZE = "A4";
	
	void setIrum(String irum);
	void setPhone(String phone);
	void printData();
	
	// java 1.8 이후에 가능 default나 static 붙이면 선언 가능 
	default void display(boolean b) {
		if(b) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
	}
	
	static void play() {
		System.out.println("play 메소드");
	}
}
