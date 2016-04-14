package Views;

import Helpers.TravelPriceController;
import Helpers.TravelProductController;
import Models.TravelPrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelPriceChangeFrame {
	private JFrame frame;
	private JPanel panel;
	private JTextField priceTextField;
	private JButton saveButton;
	private JLabel nameLabel;
	private JLabel endDateLabel;
	private JLabel startDateLabel;
	private JLabel priceLabel;
	private JTextField startDateTextField;
	private JTextField endDateTextField;
	private JComboBox productComboBox;

	private TravelPriceController travelPriceController;
	private TravelProductController travelProductController;

	private TravelPrice travelPrice;

	public TravelPriceChangeFrame(TravelPrice input) {
		this.travelPriceController = new TravelPriceController();
		this.travelProductController = new TravelProductController();
		this.travelPrice = input;

		this.productComboBox.setModel(travelProductController.getAllNames());

		this.productComboBox.setSelectedItem(this.travelPrice.getTravel_product_id());
		this.priceTextField.setText(String.valueOf(this.travelPrice.getPrice()));

		if (this.travelPrice.getStart_date() != null) {
			this.startDateTextField.setText(this.travelPrice.getStart_date().toString());
		}
		if (this.travelPrice.getEnd_date() != null) {
			this.endDateTextField.setText(this.travelPrice.getEnd_date().toString());
		}

		this.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isNew = false;

				if (travelPrice.getTravel_product_id() == null) {
					isNew = true;
				}

				travelPrice.setTravel_product_id(productComboBox.getSelectedItem().toString());
				travelPrice.setPrice(Float.valueOf(priceTextField.getText()));
				travelPrice.setStart_date(java.sql.Date.valueOf(startDateTextField.getText()));
				travelPrice.setEnd_date(java.sql.Date.valueOf(endDateTextField.getText()));

				if (isNew) {
					travelPriceController.insert(travelPrice);
					frame.dispose();
					return;
				}

				travelPriceController.update(travelPrice);
				frame.dispose();
				return;
			}
		});

		this.frame = new JFrame("TravelPriceChangeFrame");
		this.frame.setContentPane(panel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
