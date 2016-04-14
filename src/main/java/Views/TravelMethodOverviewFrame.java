package Views;

import Helpers.TravelMethodController;
import Models.TravelMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelMethodOverviewFrame {
	private JFrame frame;
	private JTable travelMethodTable;
	private JPanel panel;
	private JButton refreshButton;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;

	private TravelMethodController travelMethodController;

	public TravelMethodOverviewFrame() {
		travelMethodController = new TravelMethodController();

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TravelMethod travelMethod = new TravelMethod();
				travelMethod.setId(-1);

				new TravelMethodChangeFrame(travelMethod);
			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelMethodTable.getSelectedRow();

				if (row >= 0) {
					TravelMethod travelMethod = new TravelMethod();
					travelMethod.setId(Integer.parseInt(travelMethodTable.getValueAt(row, 0).toString()));
					travelMethod.setName(travelMethodTable.getValueAt(row, 1).toString());

					new TravelMethodChangeFrame(travelMethod);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = travelMethodTable.getSelectedRow();

				if (row >= 0) {
					TravelMethod travelMethod = new TravelMethod();
					travelMethod.setId(Integer.parseInt(travelMethodTable.getValueAt(row, 0).toString()));
					travelMethod.setName(travelMethodTable.getValueAt(row, 1).toString());

					travelMethodController.delete(travelMethod);

					refresh();
				}
			}
		});

		refresh();

		frame = new JFrame("TravelMethodOverviewFrame");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) travelMethodController.getAll();
		travelMethodTable.setModel(model);
	}
}
