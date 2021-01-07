package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class update_product extends JFrame {

	private JPanel contentPane;
	private JTextField pquantity;
	private JTextField ploc;
	private JTextField price;
	private JTextField pname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_product frame = new update_product();
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
	public update_product() {
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
		
		JLabel lblNewLabel1 = new JLabel("Update Product");
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
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		lblNewLabel_1.setBounds(304, 205, 554, 357);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(374, 245, 151, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(374, 297, 151, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Price");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(374, 339, 151, 42);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Instock");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_3.setBounds(374, 399, 151, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Location");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_4.setBounds(374, 448, 151, 27);
		contentPane.add(lblNewLabel_2_4);
		
		pquantity = new JTextField();
		pquantity.setColumns(10);
		pquantity.setBounds(545, 399, 219, 27);
		contentPane.add(pquantity);
		
		ploc = new JTextField();
		ploc.setColumns(10);
		ploc.setBounds(545, 448, 219, 27);
		contentPane.add(ploc);
		
		String[] id = new String[15];
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement(); 
			String q="select pid from product";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				id[i]=Integer.toString(rs.getInt(1));
				i++;//comboBox.Items.Add(); 
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		JComboBox comboBox_1 = new JComboBox(id);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=comboBox_1.getSelectedItem().toString(); 
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					
					String query = "SELECT name from product WHERE pid= ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, Integer.parseInt(s));
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					pname.setText(rs.getString("name"));
					pname.setEditable(false);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}

			}
		});
		comboBox_1.setBounds(545, 245, 219, 27);
		contentPane.add(comboBox_1);
		
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{					
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/inventory","root","root");  
				Statement stmt=con.createStatement(); 
				String s=comboBox_1.getSelectedItem().toString(); 
				String loc=ploc.getText();
				String stock=pquantity.getText();
				String p=price.getText();
				String sq=String.format("update product set price=%d where pid=%d",Integer.parseInt(p),Integer.parseInt(s));
				stmt.executeUpdate(sq);
				String sq1=String.format("update storage set location='%s',instock=%d where pid=%d",loc,Integer.parseInt(stock),Integer.parseInt(s));
				stmt.executeUpdate(sq1);
				JOptionPane.showMessageDialog(  contentPane, "Updated Successfully!");
				}
				catch(Exception p)
				{
					System.out.println(p);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(565, 505, 119, 36);
		contentPane.add(btnNewButton_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(545, 348, 219, 27);
		contentPane.add(price);
		
		
		
		
		
		pname = new JTextField();
		pname.setBounds(547, 297, 217, 27);
		contentPane.add(pname);
		pname.setColumns(10);
		
			}
}
