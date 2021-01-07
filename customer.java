package project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class customer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer frame = new customer();
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
	public customer() {
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(31, 163, 255, 424);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(311, 163, 255, 424);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_1_1.setBounds(596, 163, 255, 424);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_2.setBounds(45, 60, 179, 45);
		contentPane.add(lblNewLabel_2);
		
		JTextArea customer_name = new JTextArea();
		customer_name.setBounds(233, 60, 184, 38);
		contentPane.add(customer_name);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_3.setBounds(438, 63, 98, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_4.setBounds(800, 70, 168, 27);
		contentPane.add(lblNewLabel_4);
		
		JTextArea customer_contact = new JTextArea();
		customer_contact.setBounds(557, 63, 179, 36);
		contentPane.add(customer_contact);
		
		JTextArea customer_address = new JTextArea();
		customer_address.setBounds(933, 63, 201, 36);
		contentPane.add(customer_address);
		
		JTextArea soap = new JTextArea();
		int p=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Bath Soap')");
			 if (rs.next()) 
			 {
		          	p=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error abc");
		}
		if(p!=0)
		{
			soap.setText("0");
		}
		else
		{
			soap.setText("Out of Stock");
			soap.setEditable(false);
		}
			
		soap.setBounds(175, 265, 74, 22);
		contentPane.add(soap);
		
		JTextArea facewash = new JTextArea();
		int p1=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Face Wash')");
			 if (rs.next()) 
			 {
		          	p1=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p1!=0)
		{
			facewash.setText("0");
		}
		else
		{
			facewash.setText("Out of Stock");
			facewash.setEditable(false);
		}
			
		facewash.setBounds(175, 328, 72, 22);
		contentPane.add(facewash);
		
		JTextArea oil = new JTextArea();
		int p2=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Hair Oil')");
			 if (rs.next()) 
			 {
		          	p2=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p2!=0)
		{
			oil.setText("0");
		}
		else
		{
			oil.setText("Out of Stock");
			oil.setEditable(false);
		}
			
		oil.setBounds(175, 382, 72, 22);
		contentPane.add(oil);
		
		JTextArea shampoo = new JTextArea();
		int p3=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Shampoo')");
			 if (rs.next()) 
			 {
		          	p3=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p3!=0)
		{
			shampoo.setText("0");
		}
		else
		{
			shampoo.setText("Out of Stock");
			shampoo.setEditable(false);
		}
			
		shampoo.setBounds(175, 441, 72, 22);
		contentPane.add(shampoo);
		
		JTextArea gel = new JTextArea();
		int p4=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Hair Gel')");
			 if (rs.next()) 
			 {
		          	p4=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p4!=0)
		{
			gel.setText("0");
		}
		else
		{
			gel.setText("Out of Stock");
			gel.setEditable(false);
		}
			
		gel.setBounds(175, 508, 72, 22);
		contentPane.add(gel);
		
		JTextArea sprite = new JTextArea();
		int p5=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Sprite')");
			 if (rs.next()) 
			 {
		          	p5=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p5!=0)
		{
			sprite.setText("0");
		}
		else
		{
			sprite.setText("Out of Stock");
			sprite.setEditable(false);
		}
			
		sprite.setBounds(456, 265, 72, 22);
		contentPane.add(sprite);
		
		JTextArea coke = new JTextArea();
		int p6=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Coke')");
			 if (rs.next()) 
			 {
		          	p6=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p6!=0)
		{
			coke.setText("0");
		}
		else
		{
			coke.setText("Out of Stock");
			coke.setEditable(false);
		}
			
		coke.setBounds(456, 331, 72, 22);
		contentPane.add(coke);
		
		JTextArea maza = new JTextArea();
		int p7=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Maza')");
			 if (rs.next()) 
			 {
		          	p7=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p7!=0)
		{
			maza.setText("0");
		}
		else
		{
			maza.setText("Out of Stock");
			maza.setEditable(false);
		}
			
		maza.setBounds(456, 386, 72, 22);
		contentPane.add(maza);
		
		JTextArea frooti = new JTextArea();
		int p8=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Frooti')");
			 if (rs.next()) 
			 {
		          	p8=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p8!=0)
		{
			frooti.setText("0");
		}
		else
		{
			frooti.setText("Out of Stock");
			frooti.setEditable(false);
		}
			
		frooti.setBounds(456, 445, 72, 22);
		contentPane.add(frooti);
		
		JTextArea limca = new JTextArea();
		int p9=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Limca')");
			 if (rs.next()) 
			 {
		          	p9=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p9!=0)
		{
			limca.setText("0");
		}
		else
		{
			limca.setText("Out of Stock");
			limca.setEditable(false);
		}
		limca.setBounds(456, 511, 72, 22);
		contentPane.add(limca);
		
		JTextArea salt = new JTextArea();
		int p10=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Salt')");
			 if (rs.next()) 
			 {
		          	p10=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p10!=0)
		{
			salt.setText("0");
		}
		else
		{
			salt.setText("Out of Stock");
			salt.setEditable(false);
		}
		salt.setBounds(751, 265, 72, 22);
		contentPane.add(salt);
		
		JTextArea sugar = new JTextArea();
		int p11=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Sugar')");
			 if (rs.next()) 
			 {
		          	p11=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p11!=0)
		{
			sugar.setText("0");
		}
		else
		{
			sugar.setText("Out of Stock");
			sugar.setEditable(false);
		}
		sugar.setBounds(751, 331, 72, 22);
		contentPane.add(sugar);
		
		JTextArea rice = new JTextArea();
		int p12=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Rice')");
			 if (rs.next()) 
			 {
		          	p12=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p12!=0)
		{
			rice.setText("0");
		}
		else
		{
			rice.setText("Out of Stock");
			rice.setEditable(false);
		}
		rice.setBounds(751, 385, 72, 22);
		contentPane.add(rice);
		
		JTextArea wheat = new JTextArea();
		int p13=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Wheat')");
			 if (rs.next()) 
			 {
		          	p13=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p13!=0)
		{
			wheat.setText("0");
		}
		else
		{
			wheat.setText("Out of Stock");
			wheat.setEditable(false);
		}
		wheat.setBounds(751, 444, 72, 22);
		contentPane.add(wheat);
		
		JTextArea daal = new JTextArea();
		int p14=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/inventory","root","root");  
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Daal')");
			 if (rs.next()) 
			 {
		          	p14=rs.getInt(2);
		     }
		}
		catch(Exception e3)
		{
			System.out.println("Error xyz");
		}
		if(p14!=0)
		{
			daal.setText("0");
		}
		else
		{
			daal.setText("Out of Stock");
			daal.setEditable(false);
		}
		daal.setBounds(751, 511, 72, 22);
		contentPane.add(daal);
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int sum=0;
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					int p1=0;
				if(!soap.getText().equals("0") && !soap.getText().equals("Out of Stock") )
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Bath Soap'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Bath Soap')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Bath Soap left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(soap.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(soap.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Bath Soap",soap.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
					
				}
				
				if(!facewash.getText().equals("0") && !facewash.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Face Wash'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Face Wash')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Face Wash left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(facewash.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(facewash.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Face Wash",facewash.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
					 
					 
				}
				
				if(!oil.getText().equals("0") && !oil.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Hair Oil'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Hair Oil')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Hair Oil left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(oil.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(oil.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Hair Oil",oil.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!shampoo.getText().equals("0") && !shampoo.getText().equals("Out of Stock") )
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Shampoo'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Shampoo')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Shampoo left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(shampoo.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(shampoo.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Shampoo",shampoo.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
				}
				}
				
				if(!gel.getText().equals("0")  && !gel.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Hair Gel'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Hair Gel')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Hair Gel left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(gel.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(gel.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Hair Gel",gel.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
				}
				}
				
				if(!sprite.getText().equals("0") && !sprite.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Sprite'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Sprite')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Sprite left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(sprite.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(sprite.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Sprite",sprite.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
				}
				}
				
				if(!coke.getText().equals("0") && !coke.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Coke'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Coke')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Coke left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(coke.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(coke.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Coke",coke.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
				}
				}
				
				if(!maza.getText().equals("0") && !maza.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Maza'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Maza')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Maza left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(maza.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(maza.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Maza",maza.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!frooti.getText().equals("0") && !frooti.getText().equals("Out of Stock")  )
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Frooti'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Frooti')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Frooti left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(frooti.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(frooti.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Frooti",frooti.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!limca.getText().equals("0") && !limca.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Limca'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Limca')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Limca left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(limca.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(limca.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Limca",limca.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!salt.getText().equals("0") && !salt.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Salt'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Salt')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Salt left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(salt.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(salt.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Salt",salt.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
					 
				
				if(!sugar.getText().equals("0") && !sugar.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Sugar'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Sugar')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Sugar left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(sugar.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(sugar.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Sugar",sugar.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!rice.getText().equals("0") && !rice.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Rice'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Rice')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Rice left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(rice.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(rice.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Rice",rice.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!wheat.getText().equals("0") && !wheat.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Wheat'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Wheat')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Wheat left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(wheat.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(wheat.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Wheat",wheat.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				
				if(!daal.getText().equals("0") && !daal.getText().equals("Out of Stock"))
				{
					int p=0;
					ResultSet rs = stmt.executeQuery("select * from product where name='Daal'");
					 if (rs.next()) 
					 {
				          	p=rs.getInt(2);
				     }
					 ResultSet rs1 = stmt.executeQuery("select * from storage where pid =(select pid from product where name='Daal')");
					 if (rs1.next()) 
					 {
				          	p1=rs1.getInt(2);
				     }
					 String s1= "Only "+Integer.toString(p1)+" Daal left in stock.Please enter a apropriate quantity ";
					 if(p1<Integer.parseInt(daal.getText()))
						{
							JOptionPane.showMessageDialog(contentPane,s1);
							
						}
					 else  
					 {
					
					p= p*Integer.parseInt(daal.getText());
					sum=sum+p;
					String s=Integer.toString(p);
					String data[]= {"Daal",daal.getText(),s};
					DefaultTableModel tbm=(DefaultTableModel)table.getModel();
					tbm.addRow(data);
					 }
				}
				String ammount=Integer.toString(sum);
				String data1[]= {"","Total",ammount};
				DefaultTableModel tbm=(DefaultTableModel)table.getModel();
				tbm.addRow(data1);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}

					if((!soap.getText().equals("0") && !soap.getText().equals("Out of Stock"))  || 
							(!facewash.getText().equals("0") && !facewash.getText().equals("0")) || 
							(!oil.getText().equals("0") && !oil.getText().equals("0"))||
							(!shampoo.getText().equals("0") && !shampoo.getText().equals("0")) || 
							(!gel.getText().equals("0") && !gel.getText().equals("0")) || 
							(!sprite.getText().equals("0") && !sprite.getText().equals("0")) || 
							(!coke.getText().equals("0") && !coke.getText().equals("0"))|| 
							(!maza.getText().equals("0") && !maza.getText().equals("0")) || 
							(!frooti.getText().equals("0") && !frooti.getText().equals("0"))|| 
							(!limca.getText().equals("0") && !limca.getText().equals("0")) || 
							(!salt.getText().equals("0") && !salt.getText().equals("0")) || 
							(!sugar.getText().equals("0") && !sugar.getText().equals("0")) || 
							(!rice.getText().equals("0") && !rice.getText().equals("0"))||
							(!wheat.getText().equals("0") && !wheat.getText().equals("0")) || 
							(!daal.getText().equals("0") && !daal.getText().equals("0")))
				{
					JOptionPane.showMessageDialog(  contentPane, "Data added successfully!");
				}
					else
				if(     (soap.getText().equals("0") || soap.getText().equals("Out of Stock")) && 
						(facewash.getText().equals("0") ||  facewash.getText().equals("Out of Stock")) && 
						(oil.getText().equals("0")|| oil.getText().equals("Out of Stock") )&& 
						(shampoo.getText().equals("0") || shampoo.getText().equals("Out of Stock")) && 
						(gel.getText().equals("0") || gel.getText().equals("Out of Stock") ) && 
						(sprite.getText().equals("0") || sprite.getText().equals("Out of Stock")) && 
						(coke.getText().equals("0") || coke.getText().equals("Out of Stock"))&& 
						(maza.getText().equals("0") || maza.getText().equals("Out of Stock"))&& 
						(frooti.getText().equals("0") || frooti.getText().equals("Out of Stock"))&& 
						(limca.getText().equals("0") || limca.getText().equals("Out of Stock"))&& 
						(salt.getText().equals("0") || salt.getText().equals("Out of Stock"))&& 
						(sugar.getText().equals("0") || sugar.getText().equals("Out of Stock"))&& 
						(rice.getText().equals("0") || rice.getText().equals("Out of Stock") )&&
						(wheat.getText().equals("0") || wheat.getText().equals("Out of Stock")) && 
						(daal.getText().equals("0") || daal.getText().equals("Out of Stock") )
					)
				{
					JOptionPane.showMessageDialog(  contentPane, "No item is selected","Warning!", JOptionPane.WARNING_MESSAGE);
					
				}
				
				if(soap.getText().equals("Out of Stock"))
					soap.setText("Out of Stock");
				else
					soap.setText("0");
				if(facewash.getText().equals("Out of Stock"))
					facewash.setText("out of Stock");
				else
					facewash.setText("0");
				if(oil.getText().equals("Out of Stock"))
					oil.setText("Out of Stock");
				else
					oil.setText("0");
				if(shampoo.getText().equals("Out of Stock"))
					shampoo.setText("Out of Stock");
				else
					shampoo.setText("0");
				if(gel.getText().equals("Out of Stock"))
					gel.setText("Out of Stock");
				else
					gel.setText("0");
				if(sprite.getText().equals("Out of Stock"))
					sprite.setText("Out of Stock");
				else
					sprite.setText("0");
				if(coke.getText().equals("Out of Stock"))	
					coke.setText("Out of Stock");
				else
					coke.setText("0");
				if(maza.getText().equals("Out of Stock"))
					maza.setText("Out of Stock");
				else
					maza.setText("0");
				if(frooti.getText().equals("Out of Stock"))
					frooti.setText("Out of Stock");
				else
					frooti.setText("0");
				if(limca.getText().equals("Out of Stock"))
					limca.setText("Out of Stock");
				else
					limca.setText("0");
				if(salt.getText().equals("Out of Stock"))
					salt.setText("Out of Stock");
				else
					salt.setText("0");
				if(sugar.getText().equals("Out of Stock"))
					sugar.setText("Out of Stock");
				else
					sugar.setText("0");
				if(rice.getText().equals("Out of Stock"))
					rice.setText("Out of Stock");
				else
					rice.setText("0");
				if(wheat.getText().equals("Out of Stock"))
					wheat.setText("Out of Stock");
				else
					wheat.setText("0");
				if(daal.getText().equals("Out of Stock"))
					daal.setText("Out of Stock");
				else
					daal.setText("0");
				
			}
			
		});
		btnNewButton.setBounds(895, 558, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel tbm=(DefaultTableModel)table.getModel();
				final String sum = (String) tbm.getValueAt(table.getRowCount()-1, 2);
				final String p= (String) tbm.getValueAt(table.getSelectedRow(), 2);
				int s=Integer.parseInt(sum)-Integer.parseInt(p);
				if(table.getRowCount()==2)
				{
					tbm.removeRow(table.getSelectedRow());
					tbm.removeRow(table.getSelectedRow()+1);
				}
				else if(table.getSelectedRowCount()==1)
					tbm.removeRow(table.getSelectedRow());
				else if(table.getRowCount()==0)
					JOptionPane.showMessageDialog(  contentPane, "Table is already  empty","Warning!", JOptionPane.WARNING_MESSAGE);
				else
					JOptionPane.showMessageDialog(  contentPane, "Please Select single row for deletion !");
				tbm.setValueAt(Integer.toString(s), table.getRowCount()-1, 2);
			}
			
		});
		btnNewButton_1.setBounds(1013, 558, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BUY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					final String sum = (String) model.getValueAt(table.getRowCount()-1, 2);
					String cn=customer_name.getText();
					int contact=Integer.parseInt(customer_contact.getText());
					String address=customer_address.getText();
					String query1 = "select count(*) from customer";
				    ResultSet rs2 = stmt.executeQuery(query1);
				    rs2.next();
				    int c_count = rs2.getInt(1)+1;
				    String sq3=String.format("insert into customer values(%d,'%s',%d,'%s')",c_count,cn,contact,address);
					stmt.executeUpdate(sq3);
					String query = "select count(*) from orders";
				    ResultSet rs1 = stmt.executeQuery(query);
				    rs1.next();
				    int count = rs1.getInt(1)+1;
				    String sq4=String.format("insert into orders values(%d,%d,%d)",count,c_count,Integer.parseInt(sum));
					stmt.executeUpdate(sq4);
						
						int updated_val=0,id=0,s=0;
				        for (int i = 0; model.getRowCount()-1 > i; i++) 
				        {
				            final String col1 = (String) model.getValueAt(i, 0);
				            final String col2 = (String) model.getValueAt(i, 1);
				            String sq=String.format("select * from storage where pid =(select pid from product where name='%s')",col1);
							ResultSet rs=stmt.executeQuery(sq);
							while(rs.next())
							{
								id=rs.getInt(1);
								s=rs.getInt(2);
								updated_val=s-Integer.parseInt(col2);
							}
							String sqlQuery1=String.format("UPDATE storage SET instock=%d where pid=%d",updated_val,id);
							stmt.executeUpdate(sqlQuery1);
							String sq2=String.format("insert into order_summary values(%d,%d,%d)",count,id,Integer.parseInt(col2));
							stmt.executeUpdate(sq2);
							
				            
				        }
					
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
				thankyou frame2 = new thankyou();
				frame2.setVisible(true);
				dispose();
				
			}
			
			
		});
		btnNewButton_2.setBounds(1125, 558, 89, 23);
		contentPane.add(btnNewButton_2);
		JScrollPane scrollPane = new JScrollPane(table);
		//scrollPane.setVisible(aFlag);
		scrollPane.setBounds(895, 163, 306, 371);
		contentPane.add(scrollPane);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Total Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Bath Soap");
		chckbxNewCheckBox.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setBounds(44, 261, 125, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Face Wash");
		chckbxNewCheckBox_1.setForeground(Color.BLACK);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_1.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_1.setBounds(44, 329, 125, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Hair Oil");
		chckbxNewCheckBox_2.setForeground(Color.BLACK);
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_2.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_2.setBounds(44, 383, 125, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Shampoo");
		chckbxNewCheckBox_3.setForeground(Color.BLACK);
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_3.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_3.setBounds(44, 442, 125, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Hair Gel");
		chckbxNewCheckBox_4.setForeground(Color.BLACK);
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_4.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_4.setBounds(44, 509, 125, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Sprite");
		chckbxNewCheckBox_5.setForeground(Color.BLACK);
		chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_5.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_5.setBounds(327, 263, 125, 23);
		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Coke");
		chckbxNewCheckBox_6.setForeground(Color.BLACK);
		chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_6.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_6.setBounds(327, 329, 125, 23);
		contentPane.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Maza");
		chckbxNewCheckBox_7.setForeground(Color.BLACK);
		chckbxNewCheckBox_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_7.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_7.setBounds(327, 383, 125, 23);
		contentPane.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Frooti");
		chckbxNewCheckBox_8.setForeground(Color.BLACK);
		chckbxNewCheckBox_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_8.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_8.setBounds(327, 442, 125, 23);
		contentPane.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Limca");
		chckbxNewCheckBox_9.setForeground(Color.BLACK);
		chckbxNewCheckBox_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_9.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_9.setBounds(327, 509, 125, 23);
		contentPane.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Salt");
		chckbxNewCheckBox_10.setForeground(Color.BLACK);
		chckbxNewCheckBox_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_10.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_10.setBounds(612, 263, 125, 23);
		contentPane.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Sugar");
		chckbxNewCheckBox_11.setForeground(Color.BLACK);
		chckbxNewCheckBox_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_11.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_11.setBounds(612, 329, 125, 23);
		contentPane.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Rice");
		chckbxNewCheckBox_12.setForeground(Color.BLACK);
		chckbxNewCheckBox_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_12.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_12.setBounds(612, 387, 125, 23);
		contentPane.add(chckbxNewCheckBox_12);
		
		JCheckBox chckbxNewCheckBox_13 = new JCheckBox("Wheat");
		chckbxNewCheckBox_13.setForeground(Color.BLACK);
		chckbxNewCheckBox_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNewCheckBox_13.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_13.setBounds(612, 442, 125, 23);
		contentPane.add(chckbxNewCheckBox_13);
		
		JCheckBox chckbxDaal = new JCheckBox("Daal");
		chckbxDaal.setForeground(Color.BLACK);
		chckbxDaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxDaal.setBackground(new Color(0, 128, 128));
		chckbxDaal.setBounds(612, 509, 125, 23);
		contentPane.add(chckbxDaal);
		
		
	}
}
