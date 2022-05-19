package gui;

import java.awt.BorderLayout;
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
	private DefaultListModel dlm = new DefaultListModel();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreateOrderMenu dialog = new CreateOrderMenu();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
							productMenu(type);
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
						JButton btnDeleteItemFromOrder = new JButton("Slet valgte element fra ordre ");
						panel_2.add(btnDeleteItemFromOrder);
						
						
						
					}
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
	
	

	protected void threeDishMenu(Order order2) {
		JDialog threeDishMenu = new ThreeDishMenu(order);
		threeDishMenu.setVisible(true);
		
	}

	protected void saveOrder() {
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

	protected void productMenu(String type) throws SQLException, DataAccessException {
		JDialog productMenu = new ProductMenu(type, order);
		productMenu.setVisible(true);
	}

	public void init(int tableID) {
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
		timer();
	}
	
	private void updateOrderLineList() {
		DefaultListModel<OrderLine> dlm = new DefaultListModel<OrderLine>();
		ArrayList<OrderLine> dataList = orderController.getOrderLines();
		for(OrderLine element : dataList) {
			dlm.addElement(element);
		}
		listOfOrderLines.setModel(dlm);
	}
	
	public void timer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				updateOrderLineList();
				updateTotalPrice();
			}
		}, 0, 1000);
	}
	
	public void updateTotalPrice() {
		float totalPrice = 0;
		totalPrice = orderController.getTotalPrice();
		lblTotalPrice.setText("I alt : " +totalPrice+ " kr");
	}
	
	
	
}
