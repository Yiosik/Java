package geopetro.exercise1;

public class Device {
	
	private String code;
	private String modelName;
	private Integer modelYear;
	private String manufacturer;
	private Double price;
	private Integer category;
	private Integer subCategory;
	private Double discount;
	
	public Device() {
		this.code = null;
		this.modelName = null;
		this.modelYear = null;
		this.manufacturer = null;
		this.price = null;
		this.category = null;
		this.subCategory = null;
		this.discount = null;
	}
	
	public Device(
					String code, String modelName, Integer modelYear,
					String manufacturer, Double price, Integer category,
					Integer subCategory, Double discount
	) {
		this.code = code;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
		this.discount = discount;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getModelYear() {
		return modelYear;
	}
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Integer subCategory) {
		this.subCategory = subCategory;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String toString() {
		String description = "Device Description\n"
								+"------------------\n"
								+"Code: " + this.code + "\n"
								+"Model Name: " + this.modelName + "\n"
								+"Model Year: " + this.modelYear + "\n"
								+"Manufacturer: " + this.manufacturer + "\n"
								+"Price: " + this.price + "\n";
		
		return description;
	}
	
}