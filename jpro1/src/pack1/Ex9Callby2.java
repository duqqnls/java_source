package pack1;

public class Ex9Callby2 {
	public void ex(int a, int b) { // 매개변수(parameter)로 기본형 사용 = 값을 가지고 value 값을 고침
		int imsi = a;
		a = b;
		b = imsi;
		System.out.println("메소드 내의 a:" + a + ", b:" + b);
	}
	
	public void ex(Ex9Callby1 data) { // 매개변수(parameter)로 참조형 사용 -> 값을 가지고 메모리주소를 고침
		int imsi = data.a;
		data.a = data.b;
		data.b = imsi;
		System.out.println("메소드(참조형) 내의 a:" + data.a + " ,b:" + data.b);
	}
	public void ex(int[] ar) {
		int imsi = ar[0];
		ar[0] = ar[1];
		ar[1] = imsi;
		System.out.println("메소드 내의 배열요소[0]:" + ar[0] + ",[1]:" + ar[1]);
	}
}
	

