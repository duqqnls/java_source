package pack6Thread;

public class Ex41Tom extends Thread{
	@Override 
	//thread의 run 메소드 이용 
	public void run() {
		Ex41BankMain.bank.saveMoney(5000); // 1. bank 객체가 만들어진다. 2. 5000원을 입금한거임 

		System.out.println("남편 Tom 예금 후 잔고: " + Ex41BankMain.bank.getMoney());
	}
}
