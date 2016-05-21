package geopetro.exercise2;

public class Fridge extends Device {
	
	private String type;
	private String energyClass;
	private String refrigeratorCapacity;
	private String freezerCapacity;
	
	public Fridge() {
		super();
		this.type = null;
		this.energyClass = null;
		this.refrigeratorCapacity = null;
		this.freezerCapacity = null;
	}
	
	public Fridge(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String type,
			String energyClass, String refrigeratorCapacity, String freezerCapacity
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.type = type;
		this.energyClass = energyClass;
		this.refrigeratorCapacity = refrigeratorCapacity;
		this.freezerCapacity = freezerCapacity;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEnergyClass() {
		return energyClass;
	}
	public void setEnergyClass(String energyClass) {
		this.energyClass = energyClass;
	}
	public String getRefrigeratorCapacity() {
		return refrigeratorCapacity;
	}
	public void setRefrigeratorCapacity(String refrigeratorCapacity) {
		this.refrigeratorCapacity = refrigeratorCapacity;
	}
	public String getFreezerCapacity() {
		return freezerCapacity;
	}
	public void setFreezerCapacity(String freezerCapacity) {
		this.freezerCapacity = freezerCapacity;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Type: " + this.type + "\n"
						+"Energy Class: " + this.energyClass + "\n"
						+"Refrigerator Capacity: " + this.refrigeratorCapacity + "\n"
						+"Freezer Capacity: " + this.freezerCapacity + "\n";
		
		return description;
	}

}