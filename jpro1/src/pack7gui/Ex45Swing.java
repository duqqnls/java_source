package pack7gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex45Swing extends JFrame implements ActionListener{
	JLabel lblShow;
	int count = 0;

	public Ex45Swing() {
		setTitle("스윙 연습");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // top,left,buttom,right 여백주기 
		
		JButton button = new JButton("클릭");
		button.addActionListener(this);
		panel.add(button);
		
		lblShow = new JLabel("버튼 클릭 수 : 0");
		panel.add(lblShow);
		
		add(panel, BorderLayout.CENTER);
		//add("CENTER", panel); //위와 결과 동일 
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
//		addWindowListener(...); 윈도우 종료를 아래와 같이 적을 수 있다
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count += 1;
		lblShow.setText("버튼 클릭 수: " + count);
	}
	
	public static void main(String[] args) {
		new Ex45Swing();

	}

}
