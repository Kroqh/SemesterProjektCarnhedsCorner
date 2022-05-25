package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import controller.ProductController;
import controller.ProductNotFoundException;
import controller.TableController;
import database.DataAccessException;
import model.Dish;
import model.Menu;
import model.Order;
import model.Product;
import model.Table;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThreeDishMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productController;
	private JComboBox comboBoxMain;
	private JComboBox comboBoxDessertCheese;
	private JComboBox comboBoxStarter;
	private JTextField textFieldNewPrice;
	
	public ThreeDishMenu(Order order) {
		setModal(true);
		setBounds(100, 100, 675, 161);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblTitel = new JLabel("3 retters menu");
			lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblTitel, BorderLayout.NORTH);
		}
		{
			JPanel panelMain = new JPanel();
			contentPanel.add(panelMain, BorderLayout.CENTER);
			panelMain.setLayout(new BorderLayout(0, 0));
			panelMain.setPreferredSize(new Dimension( 200, 30));
			{
				comboBoxMain = new JComboBox();
				panelMain.add(comboBoxMain, BorderLayout.CENTER);
			}
		}
		{
			JPanel panelDessertCheese = new JPanel();
			contentPanel.add(panelDessertCheese, BorderLayout.EAST);
			panelDessertCheese.setLayout(new BorderLayout(0, 0));
			panelDessertCheese.setPreferredSize(new Dimension( 200, 30 ));
			{
				comboBoxDessertCheese = new JComboBox();
				panelDessertCheese.add(comboBoxDessertCheese);
			}
		}
		{
			JPanel panelStarter = new JPanel();
			contentPanel.add(panelStarter, BorderLayout.WEST);
			panelStarter.setLayout(new BorderLayout(0, 0));
			panelStarter.setPreferredSize(new Dimension( 200, 30 ));
			{
				comboBoxStarter = new JComboBox();
				panelStarter.add(comboBoxStarter);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				JLabel lblNewPrice = new JLabel("Pris:");
				panel.add(lblNewPrice);
			}
			{
				textFieldNewPrice = new JTextField();
				textFieldNewPrice.setText("350");
				panel.add(textFieldNewPrice);
				textFieldNewPrice.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setMenu(order);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init();
	}
	


	private void setMenu(Order order) {
		productController.setCurrentOrder(order);
		String dishName = (String) comboBoxStarter.getSelectedItem();
		String dishName2 = (String) comboBoxMain.getSelectedItem();
		String dishName3 = (String) comboBoxMain.getSelectedItem();
		String priceString = null;
		float price = 0;
		if (textFieldNewPrice.getText() != null) {
			priceString = textFieldNewPrice.getText();
			price = Float.parseFloat(priceString);
		}
		Product menu = productController.create3DishMenu(price, dishName, dishName2, dishName3);

			try {
				productController.saveMenu(menu);
				productController.addMenuToOrder(menu);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e);
			}

		this.dispose();
	}

	private void init() {
		productController = new ProductController();
		initializeComboBoxes();
	}

	private void initializeComboBoxes() {
		Thread t1 = new Thread("T1" ) {
			
			public void run() {
					initializeComboBox(comboBoxStarter, "forret");
			}
		};
		
		Thread t2 = new Thread("T2") {
			public void run() {
				initializeComboBox(comboBoxMain, "hovedret");
			}
		};
		Thread t3 = new Thread("T2") {
			public void run() {
				initializeComboBox(comboBoxDessertCheese, "dessert/ost");
			}
		};
		t1.start();
		t2.start();
		t3.start();
		
	}



	private void initializeComboBox(JComboBox comboBox, String dishType) {
		ArrayList<Product> products = new ArrayList<>();
		try {
			products = productController.findAllProductsByType(dishType);
		}catch (ProductNotFoundException e) {
			JOptionPane.showMessageDialog(this, e);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(this, "Der kunne ikke oprettes forbindelse til database, prøv igen");
		}
		Product product = null;
		for(int i = 0; i < products.size(); i++) {
			product = products.get(i);
			productController.addProductToTempList(product);
			comboBox.addItem(product.getName());
		}
	}


}
