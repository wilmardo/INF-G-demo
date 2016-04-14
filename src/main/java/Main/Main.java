package Main;

import Views.*;

public class Main {
	public static void main(String[] args) {
		new MedewerkersFrame().setVisible(true);
		new PhysicalProductOrderlineFrame().setVisible(true);
		new TargetFrame().setVisible(true);
		new TravelMethodOverviewFrame();
		new TravelLocationOverviewFrame();
		new TravelProductOverviewFrame();
		new TravelPriceOverviewFrame();
	}
}