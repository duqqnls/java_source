package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest8 extends JFrame implements ActionListener {
	JTextField txtName, txtJumin1, txtJumin2;
	JButton btnY = new JButton("확인");
	JLabel gogekName, gogekJumin;
	JTextArea txtResult = new JTextArea(55,35);
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest8 () {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql =""; 
			
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
		JLabel lbl1 = new JLabel("고객명 : ");
		txtName = new JTextField("", 5);
		JLabel lbl2 = new JLabel("주민번호 : ");
		
		
		
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new DbTest8();

	}

}
