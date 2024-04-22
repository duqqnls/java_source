//빵 생산자
package pack6Thread;

public class Ex42BreadMaker extends Thread{ 
	private Ex42BreadPlate plate;
	
	public Ex42BreadMaker(Ex42BreadPlate plate) {
		this.plate = plate; 
	}
	
	public void run() {
		for (int i = 0; i < 30; i++) {
			plate.makeBread();
		}
	}
}
