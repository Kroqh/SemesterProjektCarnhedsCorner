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
import controller.TableController;
import database.DataAccessException;
import model.Dish;
import model.Menu;
import model.Order;
import model.Product;
import model.Table;

import javax.swing.JLabel;
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
	
//	public static void main(String[] args) {
//		try {
//			Order order = new Order(0);
//			ThreeDishMenu threeDishMenu = new ThreeDishMenu(order);
//			threeDishMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			threeDishMenu.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * Create the dialog.
	 */
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
	


	protected void setMenu(Order order) {
		OrderController orderController = new OrderController();
		orderController.setCurrentOrder(order);
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
			orderController.addMenuToOrder(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}

	private void init() {
		productController = new ProductController();
		initializeComboBox(comboBoxStarter, "forret");
		initializeComboBox(comboBoxMain, "hovedret");
		initializeComboBox(comboBoxDessertCheese, "dessert/ost");
	}

	private void initializeComboBox(JComboBox comboBox, String dishType) {
		ArrayList<Product> products = new ArrayList<>();
		try {
			products = productController.findAllProductsByType(dishType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product product = null;
		for(int i = 0; i < products.size(); i++) {
			product = products.get(i);
			productController.addProductToTempList(product);
			comboBox.addItem(product.getName());
		}
	}


}
