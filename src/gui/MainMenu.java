package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class MainMenu extends JFrame {
	
	private static final long serialVersionUID = -6994623220232755587L;
	private JPanel contentPane;
	private JDialog orderMenuGUI;

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 188, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JButton orderBtn = new JButton("Ordre");
		orderBtn.setPreferredSize(new Dimension(150, 50));
		orderBtn.setMinimumSize(new Dimension(100, 25));
		orderBtn.setMaximumSize(new Dimension(100, 25));
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createOrderMenu();
			}
		});
		
		JButton productBtn = new JButton("Varer");
		productBtn.setPreferredSize(new Dimension(150, 50));
		
		JButton employeeBtn = new JButton("Medarbejdere");
		employeeBtn.setPreferredSize(new Dimension(150, 50));
		FlowLayout fl_centerPanel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		centerPanel.setLayout(fl_centerPanel);
		centerPanel.add(orderBtn);
		centerPanel.add(productBtn);
		
		JButton customerBtn = new JButton("Kunder");
		customerBtn.setPreferredSize(new Dimension(150, 50));
		centerPanel.add(customerBtn);
		centerPanel.add(employeeBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitel = new JLabel("Hoved Menu");
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblTitel);
	}
	
	public void createMainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
	}
	
	public void createOrderMenu() {
		orderMenuGUI = new CreateOrderMenu();
		orderMenuGUI.setVisible(true);
	}
}
