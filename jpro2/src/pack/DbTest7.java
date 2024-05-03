package pack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Connection;

public class DbTest7 extends JFrame implements ActionListener {
	JTextField txtCode, txtName, txtAmount, txtUnit;
	JButton btnAdd = new JButton("추가");
	JLabel totalCode, totalName, totalAmount, totalUnit, totalMoney;
	JTextArea txtResult = new JTextArea(55,35);
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest7() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql =""; 
			
			setTitle("상품 처리");
			
			layInit();
			
			setBounds(800,800,800,800);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			} catch (Exception e) {
				System.out.println("DbTest7 err : " + e);
			}
		}
	
	
	public void layInit() {
		// 1행
		JPanel panel1 = new JPanel();
		JLabel lbl1 = new JLabel("코드 : ");
		txtCode = new JTextField("", 5);
		JLabel lbl2 = new JLabel("품명 : ");
		txtName = new JTextField("", 5);
		JLabel lbl3 = new JLabel("수량 : ");
		txtAmount = new JTextField("", 5);
		JLabel lbl4 = new JLabel("단가 : ");
		txtUnit = new JTextField("", 5);
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
	
		panel1.add(lbl1);
		panel1.add(txtCode);
		panel1.add(lbl2);
		panel1.add(txtName);
		panel1.add(lbl3);
		panel1.add(txtAmount);
		panel1.add(lbl4);
		panel1.add(txtUnit);
		panel1.add(btnAdd);
	    add(panel1, BorderLayout.NORTH);
	    
	    txtResult.setText("결과");
	    JScrollPane scrollPane = new JScrollPane(txtResult);
	    add(scrollPane, BorderLayout.CENTER);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력 자료 오류 검사
		if (txtCode.getText().equals("")) {
			txtResult.setText("코드를 입력하세요.");
			txtCode.requestFocus();
			return;
		}
		if (txtName.getText().equals("")) {
			txtResult.setText("품명을 입력하세요.");
			txtName.requestFocus();
			return;
		}
		if (txtAmount.getText().equals("")) {
			txtResult.setText("수량을 입력하세요.");
			txtAmount.requestFocus();
			return;
		}
		if (txtUnit.getText().equals("")) {
			txtResult.setText("단가를 입력하세요.");
			txtUnit.requestFocus();
			return;
		}
		
		//숫자 형태 오류 검사
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		try {
			num1 = Integer.parseInt(txtCode.getText());
		} catch (Exception e2) {
			txtResult.setText("코드의 값은 정수만 가능합니다.");
			txtCode.requestFocus();
			return;
		}
		
		try {
			num2 = Integer.parseInt(txtAmount.getText());
		} catch (Exception e2) {
			txtResult.setText("수량의 값은 정수만 가능합니다.");
			txtAmount.requestFocus();
			return;
		}
		
		try {
			num3 = Integer.parseInt(txtUnit.getText());
		} catch (Exception e2) {
			txtResult.setText("단가의 값은 정수만 가능합니다.");
			txtUnit.requestFocus();
			return;
		}
		
		//계산
		int totalMoney = num2 * num3;
		txtResult.setText("금액 : " + totalMoney);
		
		
	}
		public static void main(String[] args) {
			new DbTest7();
		}
	}
	

	

	