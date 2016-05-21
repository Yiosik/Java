package geopetro.exercise1;

public class TV extends Device {
	
	private String type;
	private String screenSize;
	private String resolution;
	private String[] ports;
	
	public TV() {
		super();
		this.type = null;
		this.screenSize = null;
		this.resolution = null;
		this.ports = null;
	}
	
	public TV(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String type,
			String screenSize, String resolution, String[] ports
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.type = type;
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.ports = ports;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String[] getPorts() {
		return ports;
	}
	public void setPorts(String[] ports) {
		this.ports = ports;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Type: " + this.type + "\n"
						+"Screen size: " + this.screenSize + "\n"
						+"Resolution: " + this.resolution + "\n"
						+"Ports:";
		
		for(String port : this.ports)
		{ description += " "+port; }
		
		description += "\n";
		
		return description;
	}

}