package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class search_product extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField search_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					search_product frame = new search_product();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public search_product() {
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
		
		JLabel lblNewLabel1 = new JLabel("Search Product");
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
		btnNewButton.setBounds(1064, 519, 151, 49);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 174, 578, 293);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Product ID", "Name", "Price", "Location", "Instock"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		lblNewLabel_1.setBounds(654, 174, 572, 173);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(719, 218, 186, 31);
		contentPane.add(lblNewLabel_2);
		
		search_id = new JTextField();
		search_id.setBounds(915, 218, 257, 31);
		contentPane.add(search_id);
		search_id.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=search_id.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					String q="select pid from product";
					ResultSet rs = stmt.executeQuery(q);
					int cnt=0;
					
					while(rs.next())
					{
						
						if((rs.getInt(1))==Integer.parseInt(id))
						{
							 table.addRowSelectionInterval(Integer.parseInt(id)-1,Integer.parseInt(id)-1);
						     table.setBackground(Color.white);
						     table.setForeground(Color.BLACK);
						     cnt++;
						}
					}
					if(cnt==0)
						JOptionPane.showMessageDialog(  contentPane, "Product is not present","Warning!", JOptionPane.WARNING_MESSAGE);
				}
				catch(Exception e1)
				{
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(883, 294, 129, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show Product Data");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/inventory","root","root");  
					Statement stmt=con.createStatement(); 
					String q="select p.pid,p.name,p.price,s.location,s.instock from product p,storage s where p.pid=s.pid";
					ResultSet rs = stmt.executeQuery(q);
					while(rs.next())
					{
						String data[]= {Integer.toString(rs.getInt(1)), rs.getString("name"),Integer.toString(rs.getInt(3)),
								rs.getString("location"),Integer.toString(rs.getInt(5))};
						DefaultTableModel tbm=(DefaultTableModel)table.getModel();
						tbm.addRow(data);
					}
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(200, 505, 263, 63);
		contentPane.add(btnNewButton_2);
	}
}
