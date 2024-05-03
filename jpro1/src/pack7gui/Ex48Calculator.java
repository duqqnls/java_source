package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48Calculator extends JFrame implements ActionListener {
	JTextField txtNum1, txtNum2;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdoP, rdoM, rdoT, rdoD;
	JLabel lblResult;
	JButton btnOk, btnR, btnB;

	
	
	public Ex48Calculator() {
		super("미니 계산기");
		
		layoutInit();
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		// 종료 버튼  
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			int getout = JOptionPane.showConfirmDialog(Ex48Calculator.this, 
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
		JLabel lbl1 = new JLabel("숫자1 : ");
		txtNum1 = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtNum1);
		add(panel1); // Frame에 등록
		
		// 2행
		JLabel lbl2 = new JLabel("숫자2 : ");
		txtNum2 = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtNum2);
		add(panel2); // Frame에 등록
		
		// 3행
		JLabel lbl3 = new JLabel("연산선택 : ");
		rdoP = new JRadioButton(" + ", true);
		rdoM = new JRadioButton(" - ", false);
		rdoT = new JRadioButton(" * ", false);
		rdoD = new JRadioButton(" / ", false);
		
		buttonGroup.add(rdoP);
		buttonGroup.add(rdoM);
		buttonGroup.add(rdoT);
		buttonGroup.add(rdoD);
		
		JPanel panel3 = new JPanel();
		panel3.add(lbl3);
		panel3.add(rdoP);
		panel3.add(rdoM);
		panel3.add(rdoT);
		panel3.add(rdoD);
		
		add(panel3);
		
		// 4행
		lblResult = new JLabel("결과 : ", JLabel.CENTER);
		add(lblResult);
		
		// 5행
		btnOk = new JButton("계산");
		btnR = new JButton("초기화");
		btnB = new JButton("종료");
		btnOk.addActionListener(this);
		btnR.addActionListener(this);
		btnB.addActionListener(this);
		
		JPanel panel5 = new JPanel();
		panel5.add(btnOk);
		panel5.add(btnR);
		panel5.add(btnB);
		add(panel5);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// 입력 자료 오류 검사
		if(txtNum1.getText().equals("")) {
			lblResult.setText("Num1의 값 입력해주세요");
			txtNum1.requestFocus();
			return;
		}
		if(txtNum2.getText().equals("")) {
			lblResult.setText("Num2의 값 입력해주세요");
			txtNum2.requestFocus();
			return;
		}
		
		// 숫자 형태 오류 검사 
		int num1 = 0;
		int num2 = 0;
			try {
				num1 = Integer.parseInt(txtNum1.getText());
			} catch (Exception e2) {
				lblResult.setText("Num1의 값은 정수만 가능합니다.");
				txtNum1.requestFocus();
				return;
			}
			
			try {
				num2 = Integer.parseInt(txtNum2.getText());
			} catch (Exception e2) {
				lblResult.setText("Num2의 값은 정수만 가능합니다.");
				txtNum2.requestFocus();
				return;
			}
			
		// 라디오 버튼 선택 여부 확인
		System.out.println(rdoP.isSelected() + " " + rdoM.isSelected() + 
		" " + rdoT.isSelected() + " " + rdoD.isSelected());
		String calcuator = "";
		if(rdoP.isSelected()) {
			calcuator = "+";
		}else if(rdoM.isSelected()) {
			calcuator = "-";
		}else if(rdoT.isSelected()) {
			calcuator = "*";
		}else {
			calcuator = "/";
		}
		
		// 계산 
		int res = 0;

		switch (calcuator) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num1 / num2;
			break;
		}	
		
		lblResult.setText(Integer.toString(res));
		
		String message = " 결과 : " + txtNum1.getText() + calcuator + txtNum2.getText() 
		+ " = " + res;
		lblResult.setText(message);

		// 버튼 초기화생성
		if(e.getSource() == btnR) {
			txtNum1.setText("");
			txtNum2.setText("");
			rdoP.setSelected(true);
			rdoM.setSelected(false);
			rdoT.setSelected(false);
			rdoD.setSelected(false);
			lblResult.setText("결과: ");
		}else {
			int getout = JOptionPane.showConfirmDialog(this, "정말 종료하실건가요?", "종료 확인", JOptionPane.YES_NO_OPTION);
			if(getout == 0) System.exit(0);
			else return;
		}

	}
	
	public static void main(String[] args) {
		new Ex48Calculator();
	}

}
