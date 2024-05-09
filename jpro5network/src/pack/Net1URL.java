package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹서버 컴의 문서 읽기
// 인터넷이 가능한 서버들의 자원에 접근하여 주소 및 기타 정보를 다루는 클래스 

public class Net1URL {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net/");
			// file:///C:/Song/ok.html 내 컴퓨터에 저장된 html문서를 브라우저가 읽음 ! = parshing ~ 
			// https://www.naver.com:80/index.html 
			// http 보안용 서버 --> https. tcp 프로토콜 기반 응용 프로그램 계층에서 사용
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			PrintWriter printWriter = new PrintWriter(System.out, true);
//			System.out.println(br.read());
			
			PrintWriter pw = new PrintWriter(System.out, true);
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/Song/ok.html"));
			
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line); // console로 출력
				fw.println(line); // file로 저장 
				fw.flush(); // buffer 비운다. 
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}

}
