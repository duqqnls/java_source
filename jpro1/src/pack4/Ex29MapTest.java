package pack4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex29MapTest {

	public static void main(String[] args) {
		// Map류의 HashMap로 연습 : 자료를 키와 값으로 저장, 검색이 편리 
		HashMap<String, String> list = new HashMap<String, String> ();
		list.put("1", "song");
		list.put("2", "yeo");
		list.put("3", "bin");
		list.put("4", "hi");
		
		System.out.println("크기 : " + list.size());
		System.out.println(list.containsKey("2"));
		System.out.println(list.containsKey("7"));
		System.out.println(list.containsValue("han"));
		
		System.out.println();
		Set set = list.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
			System.out.println(list.get(ss));
		}
	}

}
