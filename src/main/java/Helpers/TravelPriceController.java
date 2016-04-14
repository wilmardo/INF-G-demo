package Helpers;

import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.*;

import Models.*;

public class TravelPriceController {
	private DBController dbController;
	private String tableName;

	public TravelPriceController() {
		dbController = new DBController();
		tableName = "travel_price";
	}

	public TableModel getAll() {
		ResultSet resultSet;

		try {
			resultSet = DBController.statement.executeQuery("SELECT product.`name`, price.`start_date`, price.`end_date`, price.`price` FROM `INF-G`.`" + tableName + "` price " +
					"LEFT JOIN `INF-G`.`travel_product` product ON price.`fk_travel_product_id` = product.`fk_product_id` ");
			return DBController.buildTableModel(resultSet);

		} catch (SQLException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public void insert(TravelPrice travelPrice) {
		try {
			String statement = "INSERT INTO `INF-G`.`" + tableName + "` (fk_travel_product_id, start_date, end_date, price) " +
					"VALUES ((SELECT fk_product_id FROM `INF-G`.`travel_product` WHERE name = ?), " +
					"?, ?, ?)";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelPrice.getTravel_product_id());
			preparedStatement.setDate(2, travelPrice.getStart_date());
			preparedStatement.setDate(3, travelPrice.getEnd_date());
			preparedStatement.setFloat(4, travelPrice.getPrice());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelPriceController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void update(TravelPrice travelPrice) {
		try {
			String statement = "UPDATE `INF-G`.`" + tableName + "` SET " +
					"`fk_travel_product_id` = (SELECT fk_product_id FROM `INF-G`.`travel_product` WHERE name = ?), " +
					"`start_date` = ?, " +
					"`end_date` = ?, " +
					"`price` = ? " +
					"WHERE " +
						"`fk_travel_product_id` = (SELECT fk_product_id FROM `INF-G`.`travel_product` WHERE name = ?) AND " +
						"`start_date` = ? AND " +
						"`end_date` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelPrice.getTravel_product_id());
			preparedStatement.setDate(2, travelPrice.getStart_date());
			preparedStatement.setDate(3, travelPrice.getEnd_date());
			preparedStatement.setFloat(4, travelPrice.getPrice());
			preparedStatement.setString(5, travelPrice.getTravel_product_id());
			preparedStatement.setDate(6, travelPrice.getStart_date());
			preparedStatement.setDate(7, travelPrice.getEnd_date());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelPriceController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(TravelPrice travelPrice) {
		try {
			String statement = "DELETE FROM `INF-G`." + tableName + " WHERE " +
					"`fk_travel_product_id` = (SELECT fk_product_id FROM `INF-G`.`travel_product` WHERE name = ?) AND " +
					"`start_date` = ? AND " +
					"`end_date` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelPrice.getTravel_product_id());
			preparedStatement.setDate(2, travelPrice.getStart_date());
			preparedStatement.setDate(3, travelPrice.getEnd_date());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelPriceController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
