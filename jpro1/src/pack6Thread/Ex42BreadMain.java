package pack6Thread;

public class Ex42BreadMain {
	
	public static void main(String[] args) {
		// 스레드 간 자원 공유 및 스레드 활성화 / 비활성화 연습 
		Ex42BreadPlate breadplate = new Ex42BreadPlate();
		
		Ex42BreadMaker maker = new Ex42BreadMaker(breadplate);
		Ex42BreadEater eater = new Ex42BreadEater(breadplate);
		//maker.run();
		//eater.run(); // 단일 태스킹 ( 순차적 태스킹) ? 수정해주세염 
		maker.start();
		eater.start(); // 사용자 정의에 의한 멀티 태스킹 ! 
	}

}
