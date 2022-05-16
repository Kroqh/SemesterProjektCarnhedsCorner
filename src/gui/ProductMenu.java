package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import controller.ProductController;
import database.DataAccessException;
import model.Order;
import model.OrderLine;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String type = null;
	private ArrayList<JLabel> labelsName = null;
	private ArrayList<JLabel> labelsPrice = null;
	private ArrayList<JLabel> labelsID = null;


	/**
	 * Create the dialog.
	 * @throws DataAccessException 
	 * @throws SQLException 
	 */
	public ProductMenu(String type, Order order) throws SQLException, DataAccessException {
		labelsName = new ArrayList<>();
		labelsPrice = new ArrayList<>();
		labelsID = new ArrayList<>();
		this.type = type;
		setModal(true);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblMenuTitel = new JLabel("PlaceHolderTitel");
				panel.add(lblMenuTitel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(4, 4, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JButton btnProduct1 = new JButton("New button");
					btnProduct1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int button = 0;
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct1.setPreferredSize( new Dimension( 100, 100 ));
					panel_1.add(btnProduct1);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_1.add(lblProductID);
					lblProductID.setVisible(false);
				}
				{
					JLabel lblProduct1_Name = new JLabel("New label");
					panel_1.add(lblProduct1_Name);
					labelsName.add(lblProduct1_Name);
				}
				{
					JLabel lblProduct1_Price = new JLabel("New label");
					panel_1.add(lblProduct1_Price);
					labelsPrice.add(lblProduct1_Price);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
	
	protected void addProductToOrder(int buttonNR, int quantity, Order order) throws Exception {
		OrderController orderController = new OrderController();
		JLabel labelID = labelsID.get(buttonNR);
		String productIDString = labelID.getText();
		int productID = 0;
		try {
		productID = Integer.parseInt(productIDString);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		orderController.setCurrentOrder(order);
		orderController.addProductToOrder(productID, quantity);
	}

	public void init() throws SQLException, DataAccessException {
		intializeProducts();
	}

	private void intializeProducts() throws SQLException, DataAccessException {
		ProductController productController = new ProductController();
		ArrayList<Product> products = productController.findAllProductsByType(type);
		for (int i=0; i<products.size(); i++) {
			Product product = products.get(i);
			JLabel labelPrice = labelsPrice.get(i);
			JLabel labelName = labelsName.get(i);
			JLabel labelID = labelsID.get(i);
			labelName.setText(product.getName());
			labelPrice.setText(product.getPrice() + "kr.");
			labelID.setText(product.getID() + "");
		}
	}

}
