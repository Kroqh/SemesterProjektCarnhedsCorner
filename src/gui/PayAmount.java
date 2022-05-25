package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InsufficientPaymentException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayAmount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textAmount;
	private float amount;

	/**
	 * Create the dialog.
	 */
	public PayAmount(float totalPrice) {
		
		setModal(true);
		setBounds(100, 100, 450, 139);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblTitel = new JLabel("Indtast betalt beløb");
			lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblTitel, BorderLayout.NORTH);
		}
		{
			textAmount = new JTextField();
			contentPanel.add(textAmount, BorderLayout.CENTER);
			textAmount.setColumns(10);
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
						setAmount(totalPrice);
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
	}

	private void setAmount(float totalPrice) {
		try {
			String sAmount = textAmount.getText();
			amount = Float.parseFloat(sAmount);
			if (totalPrice > amount) {
				JOptionPane.showMessageDialog(this, "Der skal betales minimum " + (totalPrice) + " kr.");
			} else {
				this.setVisible(false);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Beløbet kan ikke være 0");
		}
	}
	
	public float getAmount() {
		return amount;
	}

}
