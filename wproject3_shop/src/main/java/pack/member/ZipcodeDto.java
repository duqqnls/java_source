package pack.member;

import lombok.Data; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data 
public class ZipcodeDto {
	private String zipcode, area1, area2, area3, area4;
}
