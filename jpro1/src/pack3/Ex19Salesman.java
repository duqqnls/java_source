package pack3;

public class Ex19Salesman extends Ex19Regular{
	private int sales;
	private double commission;
	
	public Ex19Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum,nai,salary);
		this.sales = sales;
		this.commission = commission;
	}
	
	@Override
	public double pay() {
		return salary + (sales * commission); 
	}
	
	@Override
	public void print() {
		display();
		System.out.println("수령액 :" + pay());
	
	}

}
