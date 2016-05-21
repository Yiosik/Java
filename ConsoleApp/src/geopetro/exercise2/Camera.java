package geopetro.exercise2;

public class Camera extends Device {
	
	private String type;
	private String megapixel;
	private String opticalZoom;
	private String digitalZoom;
	private String screenSize;
	
	public Camera() {
		super();
		this.type = null;
		this.megapixel = null;
		this.opticalZoom = null;
		this.digitalZoom = null;
		this.screenSize = null;
	}
	
	public Camera(
			String code, String modelName, Integer modelYear,
			String manufacturer, Double price, Integer category,
			Integer subCategory, Double discount, String type,
			String megapixel, String opticalZoom, String digitalZoom,
			String screenSize
	) {
		super(code,modelName,modelYear,manufacturer,price,category,subCategory,discount);
		this.type = type;
		this.megapixel = megapixel;
		this.opticalZoom = opticalZoom;
		this.digitalZoom = digitalZoom;
		this.screenSize = screenSize;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMegapixel() {
		return megapixel;
	}
	public void setMegapixel(String megapixel) {
		this.megapixel = megapixel;
	}
	public String getOpticalZoom() {
		return opticalZoom;
	}
	public void setOpticalZoom(String opticalZoom) {
		this.opticalZoom = opticalZoom;
	}
	public String getDigitalZoom() {
		return digitalZoom;
	}
	public void setDigitalZoom(String digitalZoom) {
		this.digitalZoom = digitalZoom;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String toString() {
		String description = super.toString();
		
		description += "Type: " + this.type + "\n"
						+"Megapixel: " + this.megapixel + "\n"
						+"Optical Zoom: " + this.opticalZoom + "\n"
						+"Digital Zoom: " + this.digitalZoom + "\n"
						+"Screen size: " + this.screenSize + "\n";
		
		return description;
	}

}