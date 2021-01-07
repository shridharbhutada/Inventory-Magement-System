package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField ename;
	private JTextField address;
	private JTextField username;
	private JTextField contact;
	private JTextField age;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1250, 650);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(85, 107, 47)));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			lblNewLabel.setBounds(31, 28, 1183, 108);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel1 = new JLabel("Registration Page");
			lblNewLabel1.setBounds(21, 38, 1235, 86);
			//lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 60));
			contentPane.add(lblNewLabel1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			lblNewLabel_2.setBounds(307, 183, 692, 390);
			contentPane.add(lblNewLabel_2);
			
			ename = new JTextField();
			ename.setBounds(459, 230, 170, 28);
			contentPane.add(ename);
			ename.setColumns(10);
			
			JButton btnNewButton = new JButton("Register");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
					{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/inventory","root","root");  
						Statement stmt=con.createStatement(); 
						String query1 = "select count(*) from employee";
					    ResultSet rs = stmt.executeQuery(query1);
					    rs.next();
					    int eid = rs.getInt(1)+1;
						String name=ename.getText();
						String c=contact.getText();
						String a=address.getText();
						String eage=age.getText();
						String user=username.getText();
						String pass = new String(passwordField.getPassword());

						
						String sq=String.format("insert into employee values(%d,'%s',%d,'%s',%d,'%s','%s')",eid,name,Integer.parseInt(c),a,Integer.parseInt(eage),user,pass);
						stmt.executeUpdate(sq);
						System.out.println("Inserted");
					
					
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
					administrator frame2 = new administrator();
					frame2.setVisible(true);
					dispose(); 
				}
				
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnNewButton.setBounds(589, 501, 149, 46);
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("Name");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(322, 230, 115, 35);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Address");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1.setBounds(328, 336, 109, 35);
			contentPane.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Username");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_2.setBounds(327, 433, 133, 35);
			contentPane.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Contact");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_3.setBounds(674, 223, 98, 35);
			contentPane.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Age");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_4.setBounds(674, 336, 98, 35);
			contentPane.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("Password");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_5.setBounds(671, 433, 123, 35);
			contentPane.add(lblNewLabel_1_5);
			
			address = new JTextField();
			address.setColumns(10);
			address.setBounds(459, 336, 170, 28);
			contentPane.add(address);
			
			username = new JTextField();
			username.setColumns(10);
			username.setBounds(459, 433, 170, 28);
			contentPane.add(username);
			
			contact = new JTextField();
			contact.setColumns(10);
			contact.setBounds(799, 230, 170, 28);
			contentPane.add(contact);
			
			age = new JTextField();
			age.setColumns(10);
			age.setBounds(799, 336, 170, 28);
			contentPane.add(age);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(804, 433, 165, 28);
			contentPane.add(passwordField);
			
	}
}
