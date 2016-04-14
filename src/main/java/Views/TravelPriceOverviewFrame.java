package Views;

import Helpers.TravelPriceController;
import Models.TravelPrice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelPriceOverviewFrame {
	private JFrame frame;
	private JTable travelPriceTable;
	private JPanel panel;
	private JButton refreshButton;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;

	private TravelPriceController travelPriceController;

	public TravelPriceOverviewFrame() {
		travelPriceController = new TravelPriceController();

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TravelPriceChangeFrame(new TravelPrice());
			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelPriceTable.getSelectedRow();

				if (row >= 0) {
					TravelPrice travelPrice = new TravelPrice();

					travelPrice.setTravel_product_id(travelPriceTable.getValueAt(row, 0).toString());
					travelPrice.setStart_date(java.sql.Date.valueOf(travelPriceTable.getValueAt(row, 1).toString()));
					travelPrice.setEnd_date(java.sql.Date.valueOf(travelPriceTable.getValueAt(row, 2).toString()));
					travelPrice.setPrice((Float) travelPriceTable.getValueAt(row, 3));

					new TravelPriceChangeFrame(travelPrice);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelPriceTable.getSelectedRow();

				if (row >= 0) {
					TravelPrice travelPrice = new TravelPrice();

					travelPrice.setTravel_product_id(travelPriceTable.getValueAt(row, 0).toString());
					travelPrice.setStart_date(java.sql.Date.valueOf(travelPriceTable.getValueAt(row, 1).toString()));
					travelPrice.setEnd_date(java.sql.Date.valueOf(travelPriceTable.getValueAt(row, 2).toString()));
					travelPrice.setPrice((Float) travelPriceTable.getValueAt(row, 3));

					travelPriceController.delete(travelPrice);

					refresh();
				}
			}
		});

		refresh();

		frame = new JFrame("TravelPriceOverviewFrame");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) travelPriceController.getAll();
		travelPriceTable.setModel(model);
	}
}
