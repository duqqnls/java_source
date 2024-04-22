package pack6Thread;

public class Ex41Wife extends Thread{
	@Override 
	//thread의 run 메소드 이용 
	public void run() {
		Ex41BankMain.bank.minusMoney(2000); // 1. bank 객체가 만들어진다. 2. 5000원을 입금한거임 

		System.out.println("부인 Wife 출금 후 잔고: " + Ex41BankMain.bank.getMoney());
	}
}
