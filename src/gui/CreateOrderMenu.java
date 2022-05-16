package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import database.DataAccessException;
import model.Order;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CreateOrderMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Order order = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateOrderMenu dialog = new CreateOrderMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrderMenu() {
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
						String type = "Appetizer";
						try {
							productMenu(type);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnAppetizers.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnAppetizers);
			}
			{
				JButton btnStarter = new JButton("Forretter");
				btnStarter.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnStarter);
			}
			{
				JButton btnMain = new JButton("Hovedretter");
				btnMain.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnMain);
			}
			{
				JButton btnDessertCheese = new JButton("Dessert/ost");
				btnDessertCheese.setPreferredSize( new Dimension( 150, 150 ));
				panel.add(btnDessertCheese);
			}
			{
				JButton btnMenu = new JButton("3 Retters menu");
				panel.add(btnMenu);
			}
			{
				JButton btnKidsMenu = new JButton("Børnemenu");
				panel.add(btnKidsMenu);
			}
			{
				JButton btnSparklingWine = new JButton("Mousserende vin");
				panel.add(btnSparklingWine);
			}
			{
				JButton btnRoseWine = new JButton("Rosévin");
				panel.add(btnRoseWine);
			}
			{
				JButton btnRedWine = new JButton("Rødvin");
				panel.add(btnRedWine);
			}
			{
				JButton btnWhiteWine = new JButton("Hvidvin");
				panel.add(btnWhiteWine);
			}
			{
				JButton btnBeer = new JButton("Øl");
				panel.add(btnBeer);
			}
			{
				JButton btnSodas = new JButton("Sodavand");
				panel.add(btnSodas);
			}
			{
				JButton btnThyEcoLemonade = new JButton("Thy øko saft");
				panel.add(btnThyEcoLemonade);
			}
			{
				JButton btnHotDrinks = new JButton("Varme Drikke");
				panel.add(btnHotDrinks);
			}
			{
				JButton btnDessertWineAvec = new JButton("Dessertvin og Avec");
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
	}

	protected void productMenu(String type) throws SQLException, DataAccessException {
		JDialog productMenu = new ProductMenu(type, order);
		productMenu.setVisible(true);
	}

	public void init() {
		OrderController orderController = new OrderController();
		orderController.CreateOrder(null);
		order = orderController.getCurrentOrder();
	}
	
}
