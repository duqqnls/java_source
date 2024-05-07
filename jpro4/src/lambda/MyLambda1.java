package lambda;

// Lambda Expression : 이름이 없는 익명 함수 (메소드)
@FunctionalInterface // 함수형 인터페이스를 명시적으로 알림 
interface HelloInter { // Lambda Expression을 사용할 인터 페이스 
	// 추상 메소드는 반드시 1개여야 함. 그리고 애를 함수형 인터페이스라고 부른다. 
	int calcData(int a, int b);
//	int calcData2(int a, int b);
}

//쓰나 안쓰나~ 가독성을 위해서 쓰는게 있음
public class MyLambda1 implements HelloInter{
	@Override
	public int calcData(int a, int b) {
		// 인터페이스의 추상 메소드를 오버라이딩 : 전통적인 방법 
		return a + b;
	}
	
	/*@Override
	public int calcData2(int a, int b) {
		return 0;
	}*/
	
	public static void main(String[] args) {
		MyLambda1 my = new MyLambda1();
		System.out.println(my.calcData(3, 4)); // 전통적 방법 
		
		System.out.println();
		// 인터페이스 변수 = 람다 표현식
		// 람다 표현식의 일반적인 구문 : (parameter ,,,) -> { body }
		HelloInter inter = (x , y) -> x + y; //6라인에서 선언한 calcData(int a, int b)가 x,y로 들어온다.
		System.out.println(inter.calcData(4, 5));
		
		HelloInter inter2 = (x , y) -> x * y; //6라인에서 선언한 calcData(int a, int b)가 x,y로 들어온다.
		System.out.println(inter2.calcData(4, 5));
	}
}