package pack7gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame : BorderLayout이 기본
// Panel : FlowLayout이 기본

public class Ex43FrameLayout extends Frame implements ActionListener { // 프레임도 컨테이너
	Panel pn1 = new Panel(); // 컨테이너(Visual Object을 담는 그릇  
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel();
	Panel pn5 = new Panel();
	Panel pn6 = new Panel();
	TextField txtBun, txtIrum;
	Button btnGo;
	CardLayout card = new CardLayout();
	
	public Ex43FrameLayout() {
		// 배치 관리자로 화면 디자인 연습 
		setLayout(new GridLayout(2, 1)); // Frame의 Layout을 변경 (2행 1열)
		
		// 첫 번째 행 디자인 
		Label lbl1 = new Label("bunho:"); // 메세지 컴포넌트 
		txtBun = new TextField("송여빈", 20); // 키보드로 자료 입력 가능
		pn1.add(lbl1); // panel에 Label 객체 담기 
		pn1.add(txtBun); // panel에 txtField 객체 담기
		pn1.setBackground(Color.YELLOW); // panel 배경색 변경
//		super.add(pn1); // Frame에 Panel을 담기 = 아직 담았지만 넣진 않았음 !!!!!  	
		
		Label lbl2 = new Label("irum:"); // 메세지 컴포넌트 
		txtIrum = new TextField("송여빈", 20); // 키보드로 자료 입력 가능
		pn2.add(lbl2); // panel에 Label 객체 담기 
		pn2.add(txtIrum); // panel에 txtField 객체 담기
		pn2.setBackground(Color.CYAN); // panel 배경색 변경
		
		pn3.setLayout(card); // FlowLayout을 CardLayout으로 변경, 전역으로 card 선언한거 있음 그래서 호출 
		pn3.add("First", pn1); // pn3에 First라는 이름으로 pn1을 담았다. 
		pn3.add("Second", pn2);
		btnGo = new Button("ok");
		btnGo.addActionListener(this); // 버튼 이벤트 감지를 위해서  
		pn4.add(pn3); // pn4 : FlowLayout
		pn4.add(btnGo);
		
		super.add(pn4); // Frame에 panel4을 담기
		
				
		// 두 번째 행 디자인
		pn5.setLayout(new BorderLayout()); // pn5:FlowLayout 을 BorderLayout으로 변경 
		pn5.setBackground(new Color(123, 123, 123));
		pn5.add("East", new Label("kbs"));
		pn5.add("West", new Label("mbc"));
		pn5.add("South", new Label("sbs"));
		pn5.add("North", new Label("ytn"));
		pn5.add("Center", new Label("tvn"));
		
		super.add(pn5);
		
		super.setTitle("레이아웃 연습");
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		
		super.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 이벤트 처리 메서드 
		// 버튼을 클릭하면 pn1과 pn2을 교체
//		System.out.println("good");
//		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("ok")) {
			btnGo.setLabel("go");
			card.show(pn3, "Second"); // pn3에 담긴 pn2를 보여줘
		} else {
			btnGo.setLabel("ok");
			card.show(pn3, "First"); // pn3에 담긴 pn1을 보여줘 
		}
	}
	
	public static void main(String[] args) {
		new Ex43FrameLayout();
		
	}
}
