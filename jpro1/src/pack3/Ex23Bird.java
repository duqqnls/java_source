package pack3;

public class Ex23Bird implements Ex23Flyer {
	@Override
	public void fly() {
		System.out.println("날개를 휘 저으며 숲으로 날라감");
		
	}
	
	@Override
	public boolean isAnimal() {
		return false;
	}
	
	@Override
	public void happy() {
		
	}
}
