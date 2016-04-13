package Views;

import Helpers.TravelLocationController;
import Models.TravelLocation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelLocationOverviewFrame {
	public static void main(String[] args) {
		new TravelLocationOverviewFrame();
	}

	private JFrame frame;
	private JTable travelLocationTable;
	private JPanel panel;
	private JButton refreshButton;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;

	private TravelLocationController travelLocationController;

	public TravelLocationOverviewFrame() {
		travelLocationController = new TravelLocationController();

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TravelLocation travelLocation = new TravelLocation();
				travelLocation.setId(-1);

				new TravelLocationChangeFrame(travelLocation);
			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelLocationTable.getSelectedRow();

				if (row >= 0) {
					TravelLocation travelLocation = new TravelLocation();
					travelLocation.setId(Integer.parseInt(travelLocationTable.getValueAt(row, 0).toString()));
					travelLocation.setName(travelLocationTable.getValueAt(row, 1).toString());

					new TravelLocationChangeFrame(travelLocation);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelLocationTable.getSelectedRow();

				if (row >= 0) {
					TravelLocation travelLocation = new TravelLocation();
					travelLocation.setId(Integer.parseInt(travelLocationTable.getValueAt(row, 0).toString()));
					travelLocation.setName(travelLocationTable.getValueAt(row, 1).toString());

					travelLocationController.delete(travelLocation);

					refresh();
				}
			}
		});

		refresh();

		frame = new JFrame("TravelLocationOverviewFrame");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) travelLocationController.getAll();
		travelLocationTable.setModel(model);
	}
}
