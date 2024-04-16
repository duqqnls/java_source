package pack3;

public class Ex16ElecPolyRadio extends Ex16ElecPolyProduct{
	
	public void volumeControl() {
		int soriSize = getVolume();
		System.out.println("Radio 소리 변경 후 " + getVolume());
	}

}
