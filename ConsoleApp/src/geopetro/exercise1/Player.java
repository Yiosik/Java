package geopetro.exercise1;

public class Player extends Device {
	
	private String type;
	private String resolution;
	private String[] mediaFormats;
	
	public Player() {
		super();
		this.type = null;
		this.resolution = null;
		this.mediaFormats = null;
	}
	
	public Player(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String type,
			String resolution, String[] mediaFormats
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.type = type;
		this.resolution = resolution;
		this.mediaFormats = mediaFormats;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String[] getMediaFormats() {
		return mediaFormats;
	}
	public void setMediaFormats(String[] mediaFormats) {
		this.mediaFormats = mediaFormats;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Type: " + this.type + "\n"
						+"Resolution: " + this.resolution + "\n"
						+"Media Formats:";
		
		for(String format : this.mediaFormats)
		{ description += " "+format; }
		
		description += "\n";
		
		return description;
	}

}