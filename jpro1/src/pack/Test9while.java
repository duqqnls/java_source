package pack;

import java.util.Scanner;
public class Test9while {

	public static void main(String[] args) {
		// 반복문 while
		// while (조건) {실행문들..}
		
		int w = 1;
		while(w <= 5) { 
			System.out.println("w=" + w + "  ");
			w += 1;
		}
		System.out.println("\nwhile 수행 후 w: " + w);
		
		System.out.println();
		int count = 0;
		while(count < 5) {
			count++;
			System.out.println("count : " + count);
			if (count == 3) {
				System.out.println("정지");
			}
			if (count == 5) {
				System.out.println("count가 5라서 종료 : " + count);
			}
		}
		
		System.out.println();
		//factorial n!은 1부터 n까지의 모든 정수의 곱을 의미
		//ex : 5! = 5*4*3*2*1 = 120
		Scanner scanner = new Scanner(System.in);
		int number = 5;
		//factorial 계산을 위한 초기값 설정
		int factorial = 1;
		int i = 1; // 반복을 위한 counter 변수
		while (i <= number) {
			System.out.println(i);
			factorial *= i;
			i++;	
		}
		System.out.printf("number는 %d factorial은 %d이다.", number, factorial);
		
		System.out.println("\n\n다중 while문 ---");
		int a = 1;
		while (a <= 3) {
			System.out.println("a: " + a);
			int b = 1;
			while(b <= 4) { 
				System.out.print("b : " + b);
				b++;
			}
			a++;
			System.out.println("b = " + b);
		}
		/*
		System.out.println();
		Scanner scanner1 = new Scanner(System.in);
		while (true) {
			System.out.print("정수 입력 (0이나 음수면 종료): " );
			int num = scanner.nextInt();
			if (num <= 0 ) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println(num + "의 약수는");
			int divisor = 1; //약수를 찾기 위해 1부터 찾는다
			while (divisor <= num) {
				if (num % divisor == 0) {
					System.out.println(divisor); //약수 출력
				}
				divisor++;
			}
		}
		*/
		System.out.println();
		// do{반복 수행문...} while(조건); = 최소 1번은 실행하는 do while문
		int k = 1;
		do { // 최소 1회는 수행
			System.out.println("k : " + k);
			k += 1;
		} while(k <= 5);
		
		System.out.println("exam ------");
		// 문1) 1 ~ 100 사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고, 합과 갯수도 출력"
		// 문2) -1, 3, -5, 7, -9, 11, ... 99 까지의 합 출력
		// 문3) 1 ~ 1000 사이의 정수중에서 소수와 그 갯수를 출력 -> 소수:1보다 크며, 1과 그 수 자체 이외의 다른 수로는 나누어떨어지지 않음.
		
		// 1번 - while문 (내가 푼 것)
		System.out.println();
		int s = 1;
		int sum =0;
		int box = 0;
		while(s < 101) {
			s += 1;
			if (s % 3 == 0) {
				if (s%2 != 0) {
	//			System.out.println(s);
					sum += s;
					s+=1;
					box ++;
				}
			}
		}
		System.out.println("합 : " + sum);
		System.out.println("갯수 : " + box);
		
		// 2번 - while문 
		/*
		System.out.println();
		int q = 0;
		while (q < 100) {
			q += 1;
			if (q % 2 == 1) {
				System.out.println("q : " + q);
			}
		}
		*/
		
		// 2번 - while - 강사님 코드
		/*
		System.out.println();
		int n=1, cnt=1, hap=0;
		while (n<100) {
			if (cnt % 2 ==0) {
				hap +=n;
			} else {
				hap += n * -1;
			} 
			System.out.println(n);
			n+=2;
			cnt += 1;
		}
		*/
		
		// 2번 - for문 
		int hap2 = 0,cnt2= 1;
		for (int c=1; c<100; c+=2) {
			if (cnt2 % 2 ==0) {
				hap2+=c;
			} else {
				hap2 += (-1) * c;
			} cnt2 += 1;
		}
		System.out.println("for 합은 " + hap2 + "입니다.");
		
		// 3번 내가 푼 코드
		System.out.println();
		int bin=0;
		while (bin < 1000) {
			bin += 1;
			if (bin % 3 == 1); {
				System.out.println("bin : " + bin);
			}
		}
		
		// 3번 - 강사님 코드
		System.out.println();
		int aa=2;
		int count2 = 0;
		int su2 = 0;
		System.out.println("1부터 100까지의 소수:");
		while(aa <= 100) {
			boolean imsi = false;
			
			int bb=2;
			while(bb<= aa -1) {
				if(aa % bb == 0) {
					imsi = true;
				}
				bb++;
			}
			if (imsi == false) {
				System.out.print(aa + " ");
				count2++;
			}
			aa++;
		}
		System.out.println("\n건수 : " + count2);
		System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지 확인");
	
		//소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 떄문이다.
		
		int num = 2; // 1은 소수가 아니므로 2부터 출발
		int count3= 0; // 건수
		System.out.println("1부터 100까지의 소수: ");
		while (num <= 100) {
		
			boolean isPrime = true; // 현재 숫자가 소수인지 판별
			int divisor = 2; // 나누는 수는 2부터 시작 
			while (divisor <= Math.sqrt(num)) {
				if (num % divisor == 0) {
					isPrime = false;
					break; //나누어 떨어지지 않으면 더 이상의 검사는 안 함
				}
				divisor ++;
			}
			if(isPrime) {
				count3++;
				System.out.println(num + " " );
			}
			num ++;
		}
		System.out.println("\n건수 : " + count2);
	}
}