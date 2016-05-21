package geopetro.exercise2;

public class WashingMachine extends Device {
	
	private String energyClass;
	private String capacity;
	private String spinSpeed;
	
	public WashingMachine() {
		super();
		this.energyClass = null;
		this.capacity = null;
		this.spinSpeed = null;
	}
	
	public WashingMachine(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String energyClass,
			String capacity, String spinSpeed
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.energyClass = energyClass;
		this.capacity = capacity;
		this.spinSpeed = spinSpeed;
	}
	
	public String getEnergyClass() {
		return energyClass;
	}
	public void setEnergyClass(String energyClass) {
		this.energyClass = energyClass;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getSpinSpeed() {
		return spinSpeed;
	}
	public void setSpinSpeed(String spinSpeed) {
		this.spinSpeed = spinSpeed;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Energy Class: " + this.energyClass + "\n"
						+"Capacity: " + this.capacity + "\n"
						+"Spin Speed: " + this.spinSpeed + "\n";
		
		return description;
	}

}