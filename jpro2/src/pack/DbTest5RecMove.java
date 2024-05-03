package pack;

import java.awt.DisplayMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Connection 객체는 필요할 때만 연결하고 끊는 것이 원칙이나 그렇지 않은 경우도 있다. 
public class DbTest5RecMove extends JFrame implements ActionListener {

	JButton btnF = new JButton("|<<");
	JButton btnP = new JButton("<");
	JButton btnN = new JButton(">");
	JButton btnL = new JButton(">>|");
	
	JTextField txtNo = new JTextField("",5);
	JTextField txtName = new JTextField("",10);
	
	Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public DbTest5RecMove() {
		super("레코드 이름");
		
		layInit();
		accDb();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void layInit() { 
		JPanel panel1 = new JPanel(); // FlowLayout 
		panel1.add(new JLabel("직원자료 : "));
		txtNo.setEditable(false); // 편집 불가
//		txtName.setEnabled(false); // 비활성화
		txtName.setEditable(false);
		panel1.add(txtNo);
		panel1.add(txtName);
		add("North", panel1);
		
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		add("Center", panel2);
		
		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);
	}
	
	public void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			processDb();
		} catch (Exception e) {
			System.out.println("accDb 에러 : " + e);
		}
	}
	
	private void processDb() {
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
					
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery("select jikwon_no,jikwon_name from jikwon");
			rs.next();
			display();
		} catch (Exception e) {
			System.out.println("processDb 에러 : " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			if(e.getSource() == btnF) rs.first();
			else if(e.getSource() == btnP) rs.previous();
			else if(e.getSource() == btnN) rs.next();
			else if(e.getSource() == btnL) rs.last();
			
			display();
		} catch (Exception e2) {

		}
	}
	
	private void display() {
		try {
//			String url="jdbc:mariadb://localhost:3306/test";
//			conn = DriverManager.getConnection(url, "root", "123");
//					
//			stmt = conn.createStatement();
//			
//			rs = stmt.executeQuery("select jikwon_no,jikwon_name from jikwon");
//			rs.next();
//			
			txtNo.setText(rs.getString("jikwon_no"));
			txtName.setText(rs.getString("jikwon_name"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest5RecMove();

	}

}
