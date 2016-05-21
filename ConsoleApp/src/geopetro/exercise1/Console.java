package geopetro.exercise1;

public class Console extends Device {
	
	private String type;
	private String processor;
	private String graphics;
	private String sound;
	private String storageCapacity;
	
	public Console() {
		super();
		this.type = null;
		this.processor = null;
		this.graphics = null;
		this.sound = null;
		this.storageCapacity = null;
	}
	
	public Console(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String type,
			String processor, String graphics, String sound,
			String storageCapacity
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.type = type;
		this.processor = processor;
		this.graphics = graphics;
		this.sound = sound;
		this.storageCapacity = storageCapacity;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getGraphics() {
		return graphics;
	}
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(String storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Type: " + this.type + "\n"
						+"Processor: " + this.processor + "\n"
						+"Graphics: " + this.graphics + "\n"
						+"Sound: " + this.sound + "\n"
						+"Storage Capacity: " + this.storageCapacity + "\n";
		
		return description;
	}
	
}