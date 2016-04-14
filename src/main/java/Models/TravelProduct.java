package Models;

public class TravelProduct {

	public int product_id;
	public String travel_product_method_id;
	public String name;
	public String description;
	public String travel_product_location_id;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getTravel_product_method_id() {
		return travel_product_method_id;
	}

	public void setTravel_product_method_id(String travel_product_method_id) {
		this.travel_product_method_id = travel_product_method_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTravel_product_location_id() {
		return travel_product_location_id;
	}

	public void setTravel_product_location_id(String travel_product_location_id) {
		this.travel_product_location_id = travel_product_location_id;
	}
}
