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
	private JComboBox comboBox;
	private ArrayList<Table> tables;
	private Table table;


	/**
	 * Create the dialog.
	 */
	public TableSelect() {
		setModal(true);
		setBounds(100, 100, 450, 185);
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
						CreateOrder();
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

	private void CreateOrder() {
//		Thread t1 = new Thread() {
//			public void run() {
				int tableID = (int) comboBox.getSelectedItem();
				tableController.setActiveTable(tableID);
				table = tables.get(tableID);
				CreateOrderMenu createOrderMenu = new CreateOrderMenu(table);
				this.dispose();
				createOrderMenu.setVisible(true);
//			}
//		};
//		Thread t2 = new Thread() {
//			public void run() {
				//this.dispose();
//			}
//		};
		
	}

	private void init() {
		tableController = new TableController();
		tables = tableController.getTables();
		initializeComboBox(tables);
	}

	private void initializeComboBox(ArrayList<Table> tables) {
		table = null;
		for(int i = 0; i < tables.size(); i++) {
			table = tables.get(i);
			if(table.isActive() == false) {
			comboBox.addItem(table.getTableID());
			}
		}
	}

}
