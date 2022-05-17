package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PayAmount dialog = new PayAmount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PayAmount() {
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
						setAmount();
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
	}

	protected void setAmount() {
		try {
		String sAmount = textAmount.getText();
		amount = Float.parseFloat(sAmount);
		this.setVisible(false);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Beløbet kan ikke være 0");
		}
	}
	
	float getAmount() {
		return amount;
	}

}
