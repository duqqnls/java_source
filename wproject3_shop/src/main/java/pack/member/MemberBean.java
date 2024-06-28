package pack.member;

import lombok.Data; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class MemberBean {
	private String id, passwd, name, email, phone,zipcode,address,job;
	
}
