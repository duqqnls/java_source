package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 인터페이스를 이용한 이벤트 처리 연습 
public class MyFrame3 extends Frame implements WindowListener, MouseListener{
	public MyFrame3() {
		//생성자
		//super("상속 사용");
		super.setTitle("상속 사용");
		
		display();
		
		super.addWindowListener(this); // 현재 Frame에 이벤트 리스너를 장착 
		addMouseListener(this);
	}
	
	void display () {
	setSize(500, 300);
	setLocation(200, 150);
	setVisible(true);
	//앞에 super. 을 붙여줘야 하지만 생략 가능, 현재 클래스에서 찾아보고 없으면 자동으로 부모 클래스에서 찾기 때문
	};
	
	//WindowListener가 가진 추상메소드 오버라이딩 
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("종료");
		setTitle("안녕 종료는 아직..");
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
		
	}
	
	//MouseListener가 가진 추상메소드 오버라이딩 
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("클릭 성공 후 점심 먹기");
		//setBackground(new Color(255, 0, 0));
		System.out.println((int)(Math.random() * 255));
		int r = 255;
		int g = 0;
		int b = 0;
		setBackground(new Color(r, g, b));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		//상속으로 Frame 띄우기
//		MyFrame2 frame = new MyFrame2();
//		frame.display();
		new MyFrame3();//위의 코드 2줄을 줄인 것
		
	}
}
