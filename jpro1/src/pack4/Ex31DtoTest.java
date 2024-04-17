package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31DtoTest {
	 ArrayList<Ex31DtoStudent> list = new ArrayList<Ex31DtoStudent>();


	public void inserList() {
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("이름입력:");
				String irum = sc.next();
				System.out.println("국어 점수:");
				int kor = sc.nextInt();
				System.out.println("영어 점수:");
				int eng = sc.nextInt();
				
				Ex31DtoStudent dto = new Ex31DtoStudent();
				dto.setIrum(irum);
				dto.setKor(kor);
				dto.setEng(eng);
				list.add(dto);
				
				System.out.println();
				System.out.println("계속할까요?(y/n)");
				if (sc.next().equalsIgnoreCase("n")) break;
			}
			catch (Exception e) {
				System.out.println("오류발생");
				break;
			}
		}
	}
	
	public void showList() {
		for (Ex31DtoStudent my:list) {
			int tot = my.getKor() + my.getEng();
			System.out.println(my.getIrum() + " " + my.getKor() + " " + my.getEng()+ " " + tot);
		}
		System.out.println("응시 인원 : " + list.size() + "명");
	}
	
	public static void main(String[] args) {
		Ex31DtoTest dtoTest = new Ex31DtoTest();
		dtoTest.inserList();
		dtoTest.showList();
	}
}
