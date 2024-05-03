package pack7gui;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex51Gui extends JFrame implements ActionListener{
	private JLabel lblphto =new JLabel();
	JTextField txtName, numKor, numEng, numMt;
	ButtonGroup buttonGroup = new ButtonGroup();
	JLabel totalResult, aveResult, alpResult,Result;
	int num1, num2, num3;
	int x, y;
	Image image;
	JButton btnOk, btnR;
	
	double hap;
	double avg;
	String a;
	
	
	public Ex51Gui () {
		super("성적 출력");
		
		layoutInit();
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		// 종료 버튼  
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			int getout = JOptionPane.showConfirmDialog(Ex51Gui.this, 
					"정말 종료하실건가요?", "종료 확인", JOptionPane.YES_NO_OPTION);
			if(getout == JOptionPane.YES_OPTION)
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			else
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("이름 : ");
		txtName = new JTextField("", 5);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1); // Frame에 등록
		
		// 2행
		JPanel panel2 = new JPanel();
		JLabel lbl2 = new JLabel("국어 : ");
		numKor = new JTextField("", 5);
		JLabel lbl3 = new JLabel("영어 : ");
		numEng = new JTextField("", 5);
		JLabel lbl4 = new JLabel("수학 : ");
		numMt = new JTextField("", 5);
		
		panel2.add(lbl2);
		panel2.add(numKor);
		panel2.add(lbl3);
		panel2.add(numEng);
		panel2.add(lbl4);
		panel2.add(numMt);
		add(panel2);
		
		// 3행
		JPanel panel3 = new JPanel();
		totalResult = new JLabel("총점: ");
		aveResult = new JLabel("평균: ");
		alpResult = new JLabel("평가: ");

		panel3.add(totalResult);
		panel3.add(aveResult);
		panel3.add(alpResult);
		add(panel3);
		
		// 4행
		btnOk = new JButton("확인");
		btnR = new JButton("초기화");
		btnOk.addActionListener(this);
		btnR.addActionListener(this);
		
		JPanel panel4 = new JPanel();
		panel4.add(btnOk);
		panel4.add(btnR);
		add(panel4);
		
		// 5행
		JLabel lbl5 = new JLabel();
		lbl5.add(lblphto);
		add(lbl5);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk && numMt.getText().equals("")) {	
		} if(e.getSource() == btnOk) {
			if(txtName.getText().equals("")) {
				Result.setText("이름 입력해");
				txtName.requestFocus();
				return;
			}if(numKor.getText().equals("")) {
				Result.setText("국어점수 입력해");
				numKor.requestFocus();
				return;
				}
			
				try {num1 = Integer.parseInt(numKor.getText());
				
			} catch (Exception e2) {
				Result.setText("국어점수1 정수로 제대로 입력!!");
				numKor.requestFocus();
				return;
			}
			 if(numEng.getText().equals("")) {
				
				Result.setText("영어점수 입력해");
				numEng.requestFocus();
				return;
				
			}try {num2 = Integer.parseInt(numEng.getText());
				
			} catch (Exception e2) {
				Result.setText("영어점수1 정수로 제대로 입력!!");
				numEng.requestFocus();
				return;
			}
			if(numMt.getText().equals("")) {
				
				Result.setText("수학점수 입력해");
				numMt.requestFocus();
				return;
			}try {num3 = Integer.parseInt(numMt.getText());
				
			} catch (Exception e2) {
				Result.setText("수학점수1 정수로 제대로 입력!!");
				numMt.requestFocus();
				return;
			}
			
			hap=num1 + num2+num3;
			totalResult.setText("결과: " + hap);
			avg=hap/3;
			aveResult.setText("평균: " + String.format("%.3f", avg));
			int selImage = 0;
			if(avg>=90) {
				a="A";
				selImage =1;
			}else if(avg>=80){
				a="B";
				selImage =1;
			}else if(avg>=70) {
				a="C";
				selImage =2;
			}else if(avg>=60) {
				a="D";
				selImage =2;
			}else {
				a="F";	
				selImage =2;
			}
			
			alpResult.setText("평가: " + a);
		
			switch(selImage) {
			case 1:
				lblphto.setIcon(new ImageIcon("/Users/bohyunkim/git/repository2/src/pack7gul/pack1.jpg"));
				break;
				
			case 2:
				lblphto.setIcon(new ImageIcon("/Users/bohyunkim/git/repository2/src/pack7gul/pack1.jpg"));
				break;
			}
		
				
			
		}else if(e.getSource() == btnR) {
			txtName.setText("");
			numKor.setText("");
			numEng.setText("");
			numMt.setText("");
			lblphto.setIcon(null);
			
			
			totalResult.setText("총점: ");
			aveResult.setText("평균 ");
			alpResult.setText("평가: ");
			}
		}
		
		
	

	public static void main(String[] args) {
		new Ex51Gui();
	}

}
