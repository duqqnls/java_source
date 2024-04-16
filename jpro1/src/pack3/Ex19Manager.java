package pack3;

public class Ex19Manager extends Ex19Regular{
	private double incentive= 4578000;
	private double salary;
	
	public Ex19Manager(String irum, int nai, double salary) {
		super(irum,nai,salary);
		this.salary = salary;

	}
	
	
	@Override
	public double pay() {
		if (salary >= 2500000) {
			return incentive += salary * 0.6;
		} else if (salary >= 2000000) {
			return incentive += salary * 0.5;
		} else {
			return incentive += salary * 0.4;
		} 
	}
	
	@Override
	public void print() {
		display();
		System.out.println("수령액 :" + pay());
	
	}
}
