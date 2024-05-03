package pack7gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex44Event extends Frame implements ActionListener{
	private Button btn1 = new Button("button1");
	private Button btn2 = new Button("button2");
	private Button btn3 = new Button("button3");
	private Button btn4 = new Button("button4");
	private Button btn5 = new Button("button5");
	
	public Ex44Event() {
		super("이벤트 연습");
		
		addLayout();
		
		setBounds(200, 200, 400, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void addLayout() {
		add("East", btn1); // Frame은 BorderLayout이 기본
		add("West", btn2);
		add("South", btn3);
		add("North", btn4);
		add("Center", btn5);
		
		btn1.addActionListener(this); // 방법 1 : 현재 클래스에 implements actionListenner를 사용  => implements
		btn2.addActionListener(this);
		
		btn3.addActionListener(new EventTest()); // 방법 2 : 내부 클래스 사용  => implements 
		
		btn4.addMouseListener(new EventTest2()); // 방법 3 : 내부 클래스 사용  => extends
		btn5.addMouseListener(new MouseAdapter() { // 방법 4 : 내부 무명 클래스 사용 => 
			@Override
			public void mouseClicked(MouseEvent e) {
				// btn5 클릭하면 수행되는 메서드 
				setTitle("버튼 5 클릭 ");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// btn1, btn2를 클릭하면 수행되는 메소드 
		
//		System.out.println(e.getActionCommand());
//		System.out.println(e.getSource());
		if(e.getSource() == btn1) { // 객체 비교 
			setTitle("버튼 1 클릭 ");
		}else if(e.getSource() == btn2) {
			setTitle("버튼 2 클릭");
		}
	}
	
	class EventTest implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				//btn3 클릭하면 수행되는 메서드
			setTitle("버튼 3 누르다니");
		}
	}
	
	class EventTest2 extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		// btn4 클릭하면 수행되는 메서드
		setTitle("버튼 마우스 이벤트로 btn4 처리");
	}
}
	public static void main(String[] args) {
		// 이벤트 처리 정리
		new Ex44Event();
	}

}
