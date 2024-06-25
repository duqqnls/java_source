package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstance();
		try {
			// MyBatis Framework 사용 
			/* 수동처리 예문 1 
			System.out.println("sangdata 추가");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("딸기");
			dataDto.setSu("5");
			dataDto.setDan("5000");
			
			dao.insData(dataDto);
			*/
			
			/* 자동처리 예문 2 
			System.out.println("sangdata 수정");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("여빈냐옹");
			dataDto.setSu("5");
			
			dao.upData(dataDto);
			*/
			
			/* 삭제 예문 3 
			System.out.println("sangdata 삭제");
			boolean b= dao.delData(100);
			if(b) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			*/
			
			System.out.println("sangdata 전체 자료 읽기");
			List<DataDto> list = dao.selectDataAll();
			System.out.println(list.size());

			for(DataDto s:list) {
				System.out.println(s.getCode() + " " +
								   s.getSang() + " " +
								   s.getSu() + " " +
								   s.getDan());
			}
			
			System.out.println("\nsangdata자료 1개 읽기");
			DataDto dto = dao.selectPart("1");
			System.out.println(dto.getCode() + " " +
					dto.getSang() + " " +
					dto.getSu() + " " +
					dto.getDan());
		} catch (Exception e) {
			System.out.println("err : " + e.getMessage());
		}
	}
}
