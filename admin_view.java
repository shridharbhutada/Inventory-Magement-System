package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_view extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_view frame = new admin_view();
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
	public admin_view() {
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
		
		JLabel lblNewLabel1 = new JLabel("Admin View");
		lblNewLabel1.setBounds(21, 38, 1235, 86);
		//lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 60));
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		lblNewLabel_2.setBounds(307, 164, 692, 438);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_product frame2 = new search_product();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(403, 312, 236, 54);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_product frame2 = new update_product();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdateProduct.setBounds(403, 406, 236, 54);
		contentPane.add(btnUpdateProduct);
		
		JButton btnAddCategory = new JButton("Add Category");
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_category frame2 = new add_category();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnAddCategory.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAddCategory.setBounds(403, 498, 236, 54);
		contentPane.add(btnAddCategory);
		
		JButton btnViewStorage = new JButton("View Storage");
		btnViewStorage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_storage frame2 = new view_storage();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnViewStorage.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewStorage.setBounds(695, 312, 225, 54);
		contentPane.add(btnViewStorage);
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_orders frame2 = new view_orders();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnViewOrders.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewOrders.setBounds(695, 406, 225, 54);
		contentPane.add(btnViewOrders);
		
		JButton btnViewEmployee = new JButton("View Employee");
		btnViewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_employee frame2 = new view_employee();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnViewEmployee.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewEmployee.setBounds(695, 498, 225, 54);
		contentPane.add(btnViewEmployee);
		
		JButton btnViewCustomer = new JButton("Search Customer");
		btnViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_customer frame2 = new view_customer();
				frame2.setVisible(true);
				dispose();
				
			}
		});
		btnViewCustomer.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewCustomer.setBounds(403, 219, 236, 54);
		contentPane.add(btnViewCustomer);
		
		JButton btnOutOfStock = new JButton("Out of Stock");
		btnOutOfStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notinstock frame2 = new notinstock();
				frame2.setVisible(true);
				dispose();
				
			}
		});
		btnOutOfStock.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnOutOfStock.setBounds(695, 219, 225, 54);
		contentPane.add(btnOutOfStock);
		
	}
}
