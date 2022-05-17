package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.OrderLine;

public class OrderListRenderer implements ListCellRenderer<OrderLine>{
	
	private DefaultListCellRenderer dfcr;

	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index,
			boolean isSelected, boolean cellHasFocus) {
		dfcr = new DefaultListCellRenderer();
		String textToShow = value.getProductName()+ "  " + value.getQuantity()+ "  " + value.getPrice();
		return dfcr.getListCellRendererComponent(list, textToShow, index, isSelected, cellHasFocus);
	}
}

