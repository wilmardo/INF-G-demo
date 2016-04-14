package Views;

import Helpers.TravelProductController;
import Models.TravelProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class TravelProductOverviewFrame {
	private JFrame frame;
	private JTable travelProductTable;
	private JPanel panel;
	private JButton refreshButton;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;

	private TravelProductController travelProductController;

	public TravelProductOverviewFrame() {
		travelProductController = new TravelProductController();

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TravelProduct travelProduct = new TravelProduct();
				travelProduct.setProduct_id(-1);

				new TravelProductChangeFrame(travelProduct);
			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelProductTable.getSelectedRow();

				if (row >= 0) {
					TravelProduct travelProduct = new TravelProduct();
					travelProduct.setProduct_id((Integer) travelProductTable.getValueAt(row, 0));
					travelProduct.setName(travelProductTable.getValueAt(row, 1).toString());
					travelProduct.setDescription(travelProductTable.getValueAt(row, 2).toString());
					travelProduct.setTravel_product_location_id(travelProductTable.getValueAt(row, 3).toString());
					travelProduct.setTravel_product_method_id(travelProductTable.getValueAt(row, 4).toString());

					new TravelProductChangeFrame(travelProduct);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelProductTable.getSelectedRow();

				if (row >= 0) {
					TravelProduct travelProduct = new TravelProduct();
					travelProduct.setProduct_id(Integer.parseInt(travelProductTable.getValueAt(row, 0).toString()));
					travelProduct.setName(travelProductTable.getValueAt(row, 1).toString());

					travelProductController.delete(travelProduct);

					refresh();
				}
			}
		});

		refresh();

		frame = new JFrame("TravelProductOverviewFrame");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) travelProductController.getAll();
		travelProductTable.setModel(model);
	}
}
