package Views;

import Helpers.TravelLocationController;
import Models.TravelLocation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelLocationChangeFrame {
	private JFrame frame;
	private JPanel panel;
	private JTextField nameField;
	private JButton saveButton;
	private JLabel nameLabel;

	private TravelLocationController travelLocationController;
	private TravelLocation travelLocation;

	public TravelLocationChangeFrame(TravelLocation input) {
		this.travelLocationController = new TravelLocationController();
		this.travelLocation = input;
		this.nameField.setText(this.travelLocation.getName());

		this.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				travelLocation.setName(nameField.getText());

				if (travelLocation.getId() == -1) {
					travelLocationController.insert(travelLocation);
					frame.dispose();
					return;
				}

				travelLocationController.update(travelLocation);
				frame.dispose();
				return;
			}
		});

		this.frame = new JFrame("TravelLocationChangeFrame");
		this.frame.setContentPane(panel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
