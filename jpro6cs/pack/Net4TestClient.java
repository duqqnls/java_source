package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		// 특정 컴의 접속 후 메세지 전달용 
		try {
//			InetAddress ia = InetAddress.getByName("127.0.0.1");
//			System.out.println(ia);
//			Socket socket = new Socket(ia, 9999); 이렇게 써도 상관 없음
			Socket socket = new Socket("127.0.0.1", 9999);  // 서버와 접속 
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(),
							StandardCharsets.UTF_8), true);
			writer.println("안녕 I'am Yeobin" + "\n"); // 서버로 자료 전송 
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client err " + e);
		}
	}
}
