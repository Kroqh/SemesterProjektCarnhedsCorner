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
import javax.swing.JOptionPane;
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
					labelsID.add(lblProductID);
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
				JPanel panel_2 = new JPanel();
				panel.add(panel_2);
				{
					JButton btnProduct2 = new JButton("New button");
					btnProduct2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct2.setPreferredSize( new Dimension( 100, 100 ));
					panel_2.add(btnProduct2);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_2.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct2_Name = new JLabel("New label");
					panel_2.add(lblProduct2_Name);
					labelsName.add(lblProduct2_Name);
				}
				{
					JLabel lblProduct2_Price = new JLabel("New label");
					panel_2.add(lblProduct2_Price);
					labelsPrice.add(lblProduct2_Price);
				}
			}
				{
					JPanel panel_3 = new JPanel();
					panel.add(panel_3);
				{
					JButton btnProduct3 = new JButton("New button");
					btnProduct3.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct3.setPreferredSize( new Dimension( 100, 100 ));
					panel_3.add(btnProduct3);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_3.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct3_Name = new JLabel("New label");
					panel_3.add(lblProduct3_Name);
					labelsName.add(lblProduct3_Name);
				}
				{
					JLabel lblProduct3_Price = new JLabel("New label");
					panel_3.add(lblProduct3_Price);
					labelsPrice.add(lblProduct3_Price);
				}
			}
			
			{
				JPanel panel_4 = new JPanel();
				panel.add(panel_4);
				{
					JButton btnProduct4 = new JButton("New button");
					btnProduct4.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct4.setPreferredSize( new Dimension( 100, 100 ));
					panel_4.add(btnProduct4);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_4.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct4_Name = new JLabel("New label");
					panel_4.add(lblProduct4_Name);
					labelsName.add(lblProduct4_Name);
				}
				{
					JLabel lblProduct4_Price = new JLabel("New label");
					panel_4.add(lblProduct4_Price);
					labelsPrice.add(lblProduct4_Price);
				}
			}
			{
				JPanel panel_5 = new JPanel();
				panel.add(panel_5);
				{
					JButton btnProduct5 = new JButton("New button");
					btnProduct5.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct5.setPreferredSize( new Dimension( 100, 100 ));
					panel_5.add(btnProduct5);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_5.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct5_Name = new JLabel("New label");
					panel_5.add(lblProduct5_Name);
					labelsName.add(lblProduct5_Name);
				}
				{
					JLabel lblProduct5_Price = new JLabel("New label");
					panel_5.add(lblProduct5_Price);
					labelsPrice.add(lblProduct5_Price);
				}
			}
			{
				JPanel panel_6 = new JPanel();
				panel.add(panel_6);
				{
					JButton btnProduct6 = new JButton("New button");
					btnProduct6.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct6.setPreferredSize( new Dimension( 100, 100 ));
					panel_6.add(btnProduct6);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_6.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct6_Name = new JLabel("New label");
					panel_6.add(lblProduct6_Name);
					labelsName.add(lblProduct6_Name);
				}
				{
					JLabel lblProduct6_Price = new JLabel("New label");
					panel_6.add(lblProduct6_Price);
					labelsPrice.add(lblProduct6_Price);
				}
			}
			{
				JPanel panel_7 = new JPanel();
				panel.add(panel_7);
				{
					JButton btnProduct7 = new JButton("New button");
					btnProduct7.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct7.setPreferredSize( new Dimension( 100, 100 ));
					panel_7.add(btnProduct7);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_7.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct7_Name = new JLabel("New label");
					panel_7.add(lblProduct7_Name);
					labelsName.add(lblProduct7_Name);
				}
				{
					JLabel lblProduct7_Price = new JLabel("New label");
					panel_7.add(lblProduct7_Price);
					labelsPrice.add(lblProduct7_Price);
				}
			}
			{
				JPanel panel_8 = new JPanel();
				panel.add(panel_8);
				{
					JButton btnProduct8 = new JButton("New button");
					btnProduct8.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct8.setPreferredSize( new Dimension( 100, 100 ));
					panel_8.add(btnProduct8);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_8.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct8_Name = new JLabel("New label");
					panel_8.add(lblProduct8_Name);
					labelsName.add(lblProduct8_Name);
				}
				{
					JLabel lblProduct8_Price = new JLabel("New label");
					panel_8.add(lblProduct8_Price);
					labelsPrice.add(lblProduct8_Price);
				}
			}
			{
				JPanel panel_9 = new JPanel();
				panel.add(panel_9);
				{
					JButton btnProduct9 = new JButton("New button");
					btnProduct9.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct9.setPreferredSize( new Dimension( 100, 100 ));
					panel_9.add(btnProduct9);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_9.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct9_Name = new JLabel("New label");
					panel_9.add(lblProduct9_Name);
					labelsName.add(lblProduct9_Name);
				}
				{
					JLabel lblProduct9_Price = new JLabel("New label");
					panel_9.add(lblProduct9_Price);
					labelsPrice.add(lblProduct9_Price);
				}
			}
			{
				JPanel panel_10 = new JPanel();
				panel.add(panel_10);
				{
					JButton btnProduct10 = new JButton("New button");
					btnProduct10.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct10.setPreferredSize( new Dimension( 100, 100 ));
					panel_10.add(btnProduct10);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_10.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct10_Name = new JLabel("New label");
					panel_10.add(lblProduct10_Name);
					labelsName.add(lblProduct10_Name);
				}
				{
					JLabel lblProduct10_Price = new JLabel("New label");
					panel_10.add(lblProduct10_Price);
					labelsPrice.add(lblProduct10_Price);
				}
			}
			{
				JPanel panel_11 = new JPanel();
				panel.add(panel_11);
				{
					JButton btnProduct11 = new JButton("New button");
					btnProduct11.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct11.setPreferredSize( new Dimension( 100, 100 ));
					panel_11.add(btnProduct11);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_11.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct11_Name = new JLabel("New label");
					panel_11.add(lblProduct11_Name);
					labelsName.add(lblProduct11_Name);
				}
				{
					JLabel lblProduct11_Price = new JLabel("New label");
					panel_11.add(lblProduct11_Price);
					labelsPrice.add(lblProduct11_Price);
				}
			}
			{
				JPanel panel_12 = new JPanel();
				panel.add(panel_12);
				{
					JButton btnProduct12 = new JButton("New button");
					btnProduct12.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct12.setPreferredSize( new Dimension( 100, 100 ));
					panel_12.add(btnProduct12);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_12.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct12_Name = new JLabel("New label");
					panel_12.add(lblProduct12_Name);
					labelsName.add(lblProduct12_Name);
				}
				{
					JLabel lblProduct12_Price = new JLabel("New label");
					panel_12.add(lblProduct12_Price);
					labelsPrice.add(lblProduct12_Price);
				}
			}
			{
				JPanel panel_13 = new JPanel();
				panel.add(panel_13);
				{
					JButton btnProduct13 = new JButton("New button");
					btnProduct13.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct13.setPreferredSize( new Dimension( 100, 100 ));
					panel_13.add(btnProduct13);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_13.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct13_Name = new JLabel("New label");
					panel_13.add(lblProduct13_Name);
					labelsName.add(lblProduct13_Name);
				}
				{
					JLabel lblProduct13_Price = new JLabel("New label");
					panel_13.add(lblProduct13_Price);
					labelsPrice.add(lblProduct13_Price);
				}
			}
			{
				JPanel panel_14 = new JPanel();
				panel.add(panel_14);
				{
					JButton btnProduct14 = new JButton("New button");
					btnProduct14.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct14.setPreferredSize( new Dimension( 100, 100 ));
					panel_14.add(btnProduct14);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_14.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct14_Name = new JLabel("New label");
					panel_14.add(lblProduct14_Name);
					labelsName.add(lblProduct14_Name);
				}
				{
					JLabel lblProduct14_Price = new JLabel("New label");
					panel_14.add(lblProduct14_Price);
					labelsPrice.add(lblProduct14_Price);
				}
			}
			{
				JPanel panel_15 = new JPanel();
				panel.add(panel_15);
				{
					JButton btnProduct15 = new JButton("New button");
					btnProduct15.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct15.setPreferredSize( new Dimension( 100, 100 ));
					panel_15.add(btnProduct15);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_15.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct15_Name = new JLabel("New label");
					panel_15.add(lblProduct15_Name);
					labelsName.add(lblProduct15_Name);
				}
				{
					JLabel lblProduct15_Price = new JLabel("New label");
					panel_15.add(lblProduct15_Price);
					labelsPrice.add(lblProduct15_Price);
				}
			}
			{
				JPanel panel_16 = new JPanel();
				panel.add(panel_16);
				{
					JButton btnProduct16 = new JButton("New button");
					btnProduct16.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
								addProductToOrder(1, 1, order);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnProduct16.setPreferredSize( new Dimension( 100, 100 ));
					panel_16.add(btnProduct16);
				}
				{
					JLabel lblProductID = new JLabel("");
					panel_16.add(lblProductID);
					lblProductID.setVisible(false);
					labelsID.add(lblProductID);
				}
				{
					JLabel lblProduct16_Name = new JLabel("New label");
					panel_16.add(lblProduct16_Name);
					labelsName.add(lblProduct16_Name);
				}
				{
					JLabel lblProduct16_Price = new JLabel("New label");
					panel_16.add(lblProduct16_Price);
					labelsPrice.add(lblProduct16_Price);
				}
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
		JLabel labelID = labelsID.get(buttonNR-1);
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

	private void intializeProducts() {
		ProductController productController = new ProductController();
		ArrayList<Product> products = new ArrayList<>();
		try {
			products = productController.findAllProductsByType(type);
		} catch (SQLException | DataAccessException e) {
			JOptionPane.showMessageDialog(this, "Der er opstået en uventet fejl i forbindelsen med servren, prøv igen");
			e.printStackTrace();
		}
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
