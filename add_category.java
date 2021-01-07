package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class add_category extends JFrame {

	private JPanel contentPane;
	private JTextField c;
	private JTextField d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_category frame = new add_category();
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
	public add_category() {
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
		
		JLabel lblNewLabel1 = new JLabel("Add Category");
		lblNewLabel1.setBounds(21, 38, 1235, 86);
		//lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 60));
		contentPane.add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_view frame = new admin_view();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(1063, 540, 151, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(326, 210, 505, 268);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(372, 251, 163, 34);
		contentPane.add(lblNewLabel_2);
		
		c = new JTextField();
		c.setBounds(556, 251, 228, 34);
		contentPane.add(c);
		c.setColumns(10);
		
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(556, 329, 228, 34);
		contentPane.add(d);
		
		JLabel lblNewLabel_2_1 = new JLabel("Description");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(372, 329, 163, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					String cat=c.getText();
					String des=d.getText();
					String q="select * from product_category";
					int cnt=0;
					ResultSet rs = stmt.executeQuery(q);
					while(rs.next())
						if(rs.getString("Category").equals(cat))
						{
							cnt++;
						}
					if(cnt==0)
					{
						String sq=String.format("insert into product_category values('%s','%s')",cat,des);
						stmt.executeUpdate(sq);
					}
					else
					{
						JOptionPane.showMessageDialog(  contentPane, "Category Already Exists","Warning!", JOptionPane.WARNING_MESSAGE);
					}
							
				}
				catch(Exception e1)
				{
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnNewButton_1.setBounds(522, 403, 151, 42);
		contentPane.add(btnNewButton_1);
	}

}
