//빵 소비자
package pack6Thread;

public class Ex42BreadEater extends Thread{ 
	private Ex42BreadPlate plate;
	
	public Ex42BreadEater(Ex42BreadPlate plate) {
		this.plate = plate; 
	}
	
	public void run() {
		for (int i = 0; i < 30; i++) {
			plate.eatBread();
		}
	}
}
