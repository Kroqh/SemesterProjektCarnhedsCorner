package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InsufficientPaymentException;
import controller.OrderController;
import controller.TableController;
import database.DataAccessException;
import model.Order;
import model.OrderLine;
import model.Table;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class CreateOrderMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Order order = null;
	private JList<OrderLine> listOfOrderLines;
	private OrderController orderController;
	private Timer timer;
	private JLabel lblTotalPrice;
	private JDialog productMenu;
	
	/**
	 * Create the dialog.
	 */
	public CreateOrderMenu(int tableID) {
		setModal(true);
		setBounds(100, 100, 960, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Sælg");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JButton btnAppetizers = new JButton("Appetizers");
				btnAppetizers.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "appetizer";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				btnAppetizers.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnAppetizers);
			}
			{
				JButton btnStarter = new JButton("Forretter");
				btnStarter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "forret";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				btnStarter.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnStarter);
			}
			{
				JButton btnMain = new JButton("Hovedretter");
				btnMain.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "hovedret";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				btnMain.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnMain);
			}
			{
				JButton btnDessertCheese = new JButton("Dessert/ost");
				btnDessertCheese.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "dessert/ost";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				btnDessertCheese.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnDessertCheese);
			}
			{
				JButton btnMenu = new JButton("3 Retters menu");
				btnMenu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						threeDishMenu(order);
					}
				});
				panel.add(btnMenu);
			}
			{
				JButton btnSparklingWine = new JButton("mousserende vin");
				btnSparklingWine.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "mousserende vin";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnSparklingWine);
			}
			{
				JButton btnRoseWine = new JButton("Rosévin");
				btnRoseWine.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "rosévin";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnRoseWine);
			}
			{
				JButton btnRedWine = new JButton("Rødvin");
				btnRedWine.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "rødvin";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnRedWine);
			}
			{
				JButton btnWhiteWine = new JButton("Hvidvin");
				btnWhiteWine.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "hvidvin";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnWhiteWine);
			}
			{
				JButton btnBeer = new JButton("Øl");
				btnBeer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "øl";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnBeer);
			}
			{
				JButton btnSodas = new JButton("Sodavand");
				btnSodas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "sodavand";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnSodas);
			}
			{
				JButton btnThyEcoLemonade = new JButton("Thy øko saft");
				btnThyEcoLemonade.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "thy øko saft";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnThyEcoLemonade);
			}
			{
				JButton btnHotDrinks = new JButton("Varme Drikke");
				btnHotDrinks.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "varme drikke";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnHotDrinks);
			}
			{
				JButton btnDessertWineAvec = new JButton("Dessertvin og Avec");
				btnDessertWineAvec.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String type = "dessertvin og avec";
						try {
							createProductMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateOrderLineList();
					}
				});
				panel.add(btnDessertWineAvec);
			}
			{
				ImageIcon imageIcon = new ImageIcon("/pictures/Øl/Heineken.JPG");
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			panel.setPreferredSize( new Dimension( 300, 960 ) );
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblNewLabel_1 = new JLabel("Carnheds Corner ApS");
					panel_1.add(lblNewLabel_1);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					listOfOrderLines = new JList<>();
					listOfOrderLines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(listOfOrderLines);
					
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.NORTH);
					{
						lblTotalPrice = new JLabel("I alt : ");
						panel_2.add(lblTotalPrice);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.SOUTH);
					{
						JButton btnPay = new JButton("Betaling");
						btnPay.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
									saveOrder();
							}
						});
						{
							JButton btnDeleteItemFromOrder = new JButton("Slet valgte element fra ordre ");
							panel_2.add(btnDeleteItemFromOrder);
							btnDeleteItemFromOrder.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {
									DeleteSelectedItem();
									
								}

								private void DeleteSelectedItem() {
									// TODO Auto-generated method stub
									DefaultListModel<OrderLine> model = (DefaultListModel<OrderLine>) listOfOrderLines.getModel();
									int selectedIndex = listOfOrderLines.getSelectedIndex();
									if (selectedIndex != -1) {
									    model.remove(selectedIndex);
									}
									else {
										System.out.println(selectedIndex);
									}
								}
							});
							
							
							
						}
						panel_2.add(btnPay);
					}
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
		init(tableID);
	}

	private void DeleteItemFromOrder() {
		
		
	}
	
	private void threeDishMenu(Order order) {
		JDialog threeDishMenu = new ThreeDishMenu(order);
		threeDishMenu.setVisible(true);	
	}

	private void saveOrder() {
		PayAmount payAmount = new PayAmount();
		payAmount.setVisible(true);
		float amount = payAmount.getAmount();
		payAmount.dispose();
		try {
			orderController.saveOrder(amount);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(this, "Der er opstået en uventet fejl i forbindelsen med serveren, prøv igen");
			e.printStackTrace();
		} catch (InsufficientPaymentException e) {
			JOptionPane.showMessageDialog(this, "Der er mangler at blive betalt yderligere " + (orderController.getTotalPrice() - amount) + " kr.");
			e.printStackTrace();
		}
	}

	private void createProductMenu(String type) throws SQLException, DataAccessException {
		productMenu = new ProductMenu(type, order);
		timer();
		productMenu.setVisible(true);
	}

	private void init(int tableID) {
		orderController = new OrderController();
		orderController.createOrder(tableID);
		order = orderController.getCurrentOrder();
		TableController tableController = new TableController();
		tableController.setOrderToTable(tableID, order);
		initializeOrderLines();
	}
	
	private void initializeOrderLines() {
		OrderListRenderer olr = new OrderListRenderer();
		listOfOrderLines.setCellRenderer(olr);
	}
	
	private void updateOrderLineList() {
		DefaultListModel<OrderLine> dlm = new DefaultListModel<OrderLine>();
		ArrayList<OrderLine> dataList = orderController.getOrderLines();
		for(OrderLine element : dataList) {
			dlm.addElement(element);
		}
		listOfOrderLines.setModel(dlm);
	}
	
	private void timer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run(){
				if (productMenu.isVisible()) {
					updateOrderLineList();
					updateTotalPrice();
				}				
			}
		}, 0, 1000);
	}
	
	private void updateTotalPrice() {
		float totalPrice = 0;
		totalPrice = orderController.getTotalPrice();
		lblTotalPrice.setText("I alt : " +totalPrice+ " kr");
	}
	
	
	
}
