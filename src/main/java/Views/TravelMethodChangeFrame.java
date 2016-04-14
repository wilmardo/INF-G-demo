package Views;

import Helpers.TravelMethodController;
import Models.TravelMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelMethodChangeFrame {
	private JFrame frame;
	private JPanel panel;
	private JTextField nameField;
	private JButton saveButton;
	private JLabel nameLabel;

	private TravelMethodController travelMethodController;
	private TravelMethod travelMethod;

	public TravelMethodChangeFrame(TravelMethod input) {
		this.travelMethodController = new TravelMethodController();
		this.travelMethod = input;
		this.nameField.setText(this.travelMethod.getName());

		this.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				travelMethod.setName(nameField.getText());

				if (travelMethod.getId() == -1) {
					travelMethodController.insert(travelMethod);
					frame.dispose();
					return;
				}

				travelMethodController.update(travelMethod);
				frame.dispose();
				return;
			}
		});

		this.frame = new JFrame("TravelMethodChangeFrame");
		this.frame.setContentPane(panel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
