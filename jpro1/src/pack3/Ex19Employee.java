package pack3;

abstract public class Ex19Employee {
	Ex19Employee (String irum, int nai) {
		this.irum = irum;
		this.nai = nai;
	};
	
	public String irum;
	public int nai;
	
	abstract public double pay();
	abstract public void print();
	
	public void display() {
		System.out.println("이름 : " + irum + ", 나이 : " + nai);
	}
}