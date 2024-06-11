package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31DtoTest {
    ArrayList<Ex31DtoStudent> list = new ArrayList<>();
    Ex31DtoStudent dto;

    public void insertList(String name, int kor, int eng) {
        dto = new Ex31DtoStudent();
        dto.setName(name);
        dto.setKor(kor);
        dto.setEng(eng);
        list.add(dto);
    }

    public void showList() {
        for (Ex31DtoStudent i : list) {
            System.out.println("이름 : " + i.getName() + ", 국어 : " + i.getKor() + ", 영어 : " + i.getEng() + ", 총점 : " + (i.getEng() + i.getKor()));
        }
        System.out.println("응시인원 : " + list.size());
    }

    public static void main(String[] args) {
        Ex31DtoTest test = new Ex31DtoTest();

        int kor, eng;
        String name, yn;

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("이름 입력 : ");
                name = sc.next();
                System.out.print("국어 점수 : ");
                kor = sc.nextInt();
                System.out.print("영어 점수 : ");
                eng = sc.nextInt();
                test.insertList(name, kor, eng); 
                test.showList();
                System.out.println("계속 할까요 ? (y/n)");

                yn = sc.next();
                if (yn.equals("n")) {
                    System.out.println("n을 입력해서 종료합니다.");
                    test.showList();
                    System.exit(0);
                } else if (yn.equals("y")) {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("처리 중 오류 발생 : " + e);
                break;
            }
        }

        sc.close(); // Scanner를 닫아서 리소스 누수를 방지합니다.
    }
}
