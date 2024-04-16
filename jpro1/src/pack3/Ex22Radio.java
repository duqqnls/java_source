package pack3;

// extends는 단일 상속만 가능하나, 인터페이스의 implements의 콤마(,)를 통해 다중 상속이 가능합니다. 
// public class Ex22Radio implements Ex22VolEtc, Ex22InterVol {
public class Ex22Radio implements Ex22InterVol{
	private int v = 0;
	
	@Override
	public void volUp(int v) {
		this.v += v;
	}
	
	@Override
	public void volDown(int v) {
		this.v -= v;
	}
	
	@Override
	public void volOff() {
		v = 0;
	}
	
	@Override
	public void volOn() {
		v = 1;
	}
	
	public void showVol() {
	
	}
	
}
