package pack4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data

public class Ex31DtoStudent {
	private String name;
	private int kor, eng;
	
	public Ex31DtoStudent() {
		
	}
	
	
//	public Ex31StudDto(String name, int kor, int eng) {
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}
