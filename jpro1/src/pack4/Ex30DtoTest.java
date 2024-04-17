package pack4;

import java.util.ArrayList;

public class Ex30DtoTest {

		// DTO : .... 레코드 단위의 기억장소 
		ArrayList<Ex30StudentDto> list = new ArrayList<Ex30StudentDto>();
		Ex30StudentDto dto; // DTO 기억장소
		
		// DTO 유추하기
		public void aa() {
			String[] persons = new String[3];
			persons[0] = "송여빈";
			persons[1] = "송코코";
			persons[2] = "송땅콩";
	
			for(String s:persons) {
				System.out.println(s);
			}
		}
		
		public void inserList() { // 레코드 단위(DTO)로 학생 정보 입력해 List에 저장 
			dto = new Ex30StudentDto();
			dto.setHakbun("ks1");
			dto.setIrum("감자");
			dto.setJumsu(90);
			list.add(dto); // 첫 번째 학생 자료 list에 등록 
			
			dto = new Ex30StudentDto();
			dto.setHakbun("ks2");
			dto.setIrum("고구마");
			dto.setJumsu(50);
			list.add(dto); // 두 번째 학생 자료 list에 등록 
		
			dto = new Ex30StudentDto();
			dto.setHakbun("ks3");
			dto.setIrum("토마토");
			dto.setJumsu(80);
			list.add(dto); // 세 번째 학생 자료 list에 등록 
		
		}
		
		public void showList() { // list 컬렉션에 저장된 학생 자료를 출력 
			System.out.println("학생 수는 " + list.size());
			System.out.println(list.get(0));
			System.out.println(list.get(0).getIrum());
			
			System.out.println();
			for(int i=0; i < list.size(); i++) {
//				Ex30StudentDto sdto = new Ex30StudentDto();
//				sdto = list.get(i);
				Ex30StudentDto sdto = list.get(i);
				System.out.println(sdto.getHakbun() + " " + sdto.getIrum() + " " + sdto.getJumsu());
			
			}	
			
			System.out.println("-----");
			for(Ex30StudentDto d:list) { 
				System.out.println(d.getHakbun() + " " + d.getIrum() + " " + d.getJumsu());
			}
		}
		
		public static void main (String[] args) {
		Ex30DtoTest dtoTest = new Ex30DtoTest();
		dtoTest.aa();
		System.out.println();
		dtoTest.inserList();
		dtoTest.showList();
		
		}

}
