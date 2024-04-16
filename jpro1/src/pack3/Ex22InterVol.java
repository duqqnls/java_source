package pack3;

// public interface Ex22InterVol {
public interface Ex22InterVol extends Ex22VolEtc { // 인터페이스간 상속도 가능하다. 
	String vol = "볼륨";
	
	void volUp(int v);
	void volDown(int v);
}
