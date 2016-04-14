package Views;

import Helpers.TravelLocationController;
import Helpers.TravelMethodController;
import Helpers.TravelProductController;
import Models.TravelProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelProductChangeFrame {
	private JFrame frame;
	private JPanel panel;
	private JTextField nameField;
	private JButton saveButton;
	private JLabel nameLabel;
	private JTextField descriptionField;
	private JComboBox locationComboBox;
	private JComboBox methodComboBox;
	private JLabel descriptionLabel;
	private JLabel locationLabel;
	private JLabel methodLabel;

	private TravelProductController travelProductController;
	private TravelLocationController travelLocationController;
	private TravelMethodController travelMethodController;

	private TravelProduct travelProduct;

	public TravelProductChangeFrame(TravelProduct input) {
		this.travelProductController = new TravelProductController();
		this.travelLocationController = new TravelLocationController();
		this.travelMethodController = new TravelMethodController();
		this.travelProduct = input;

		this.locationComboBox.setModel(travelLocationController.getAllNames());
		this.methodComboBox.setModel(travelMethodController.getAllNames());

		this.nameField.setText(this.travelProduct.getName());
		this.descriptionField.setText(this.travelProduct.getDescription());
		this.locationComboBox.setSelectedItem(this.travelProduct.getTravel_product_location_id());
		this.methodComboBox.setSelectedItem(this.travelProduct.getTravel_product_method_id());

		this.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				travelProduct.setName(nameField.getText());
				travelProduct.setDescription(descriptionField.getText());
				travelProduct.setTravel_product_location_id(locationComboBox.getSelectedItem().toString());
				travelProduct.setTravel_product_method_id(methodComboBox.getSelectedItem().toString());

				if (travelProduct.getProduct_id() == -1) {
					travelProductController.insert(travelProduct);
					frame.dispose();
					return;
				}

				travelProductController.update(travelProduct);
				frame.dispose();
				return;
			}
		});

		this.frame = new JFrame("TravelProductChangeFrame");
		this.frame.setContentPane(panel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
