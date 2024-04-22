package pack6Thread;

public class Ex41BankMain { // static으로 만든 이유는 ? 
	// 추측 1.static은 메모리 영역이 적기 때문에 아껴써야함 
	// 추측 2.Ex41Tom run()메소드와 연관있음. -> Tom과 Wife 클래스의 run()메소드를 이용후 static이있는 main으로 돌아오는듯. .? 
	
	public static Ex41Bank bank = new Ex41Bank();
	
	
	public static void main(String[] args) { // 1. Main을 실행하려면 Thread가 있어야 함
		System.out.println("원금 : " + bank.getMoney());
		
		Ex41Tom tom = new Ex41Tom();
		Ex41Wife wife = new Ex41Wife();
		
		tom.start(); 
		wife.start(); //사용자 스레드가 총 2개 즉, 통장 2개 개설된 것과 같다. = 자원공유 아직 안 되었음
		// 이렇게 각각의 스레드가 돌고 있는데, 동기화가 되지 않으면 많은 메모리를 잡아먹는다. 
	}

}
