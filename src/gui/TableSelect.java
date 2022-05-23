package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TableController;
import model.Table;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableSelect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private TableController tableController;
	private JComboBox<Integer> comboBox;
	private ArrayList<Table> tables = new ArrayList<>();
	private Table table;


	/**
	 * Create the dialog.
	 */
	public TableSelect(boolean isActive) {
		setModal(true);
		setBounds(100, 100, 450, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Vælg Bord - Nyt Salg");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				comboBox = new JComboBox();
				panel.add(comboBox);
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
						createOrder(isActive);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init(isActive);
	}
	

	private void createOrder(boolean isActive) {
				int tableID = (int) comboBox.getSelectedItem();
				CreateOrderMenu createOrderMenu = new CreateOrderMenu(tableID, isActive);
				createOrderMenu.setVisible(true);
				this.dispose();
	}

	private void init(boolean isActive) {
		tableController = new TableController();
		if(isActive) {
			tables = tableController.getActiveTables();
		} else if(!isActive) {
			tables = tableController.getInactiveTables();
		}
		initializeComboBox(tables, isActive);
	}

	private void initializeComboBox(ArrayList<Table> tables, boolean isActive) {
		table = null;
		for(int i = 0; i < tables.size(); i++) {
			table = tables.get(i);
			comboBox.addItem(table.getTableID());
		}
	}

}
