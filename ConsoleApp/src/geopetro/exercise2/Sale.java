package geopetro.exercise2;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sale {
	
	private Integer saleCode;
	private Device saleDevice;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private Date saleDate;
	private Double saleCost;
	
	public Sale() {
		this.saleCode = null;
		this.saleDevice = null;
		this.customerName = null;
		this.customerSurname = null;
		this.customerPhone = null;
		this.saleDate = null;
		this.saleCost = null;
	}
	
	public Sale(
			Integer saleCode, Device saleDevice, String customerName,
			String customerSurname, String customerPhone, Date saleDate,
			Double saleCost
	) {
		this.saleCode = saleCode;
		this.saleDevice = saleDevice;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerPhone = customerPhone;
		this.saleDate = saleDate;
		this.saleCost = saleCost;
	}

	public Integer getSaleCode() {
		return saleCode;
	}
	public void setSaleCode(Integer saleCode) {
		this.saleCode = saleCode;
	}
	public Device getSaleDevice() {
		return saleDevice;
	}
	public void setSaleDevice(Device saleDevice) {
		this.saleDevice = saleDevice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Double getSaleCost() {
		return saleCost;
	}
	public void setSaleCost(Double saleCost) {
		this.saleCost = saleCost;
	}
	public String dateToString(Date aDate) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(aDate);
		
		return cal.get(Calendar.DAY_OF_MONTH)+ "." + (cal.get(Calendar.MONTH)+1) + "." + cal.get(Calendar.YEAR);
	}
	public String toString() {
		String description = "Sale Description\n"
								+"----------------\n"
								+"Sale Code: " + this.saleCode + "\n"
								+"Sale Device: " + this.saleDevice.getModelName() + "\n"
								+"Customer Name: " + this.customerName + "\n"
								+"Customer Surname: " + this.customerSurname + "\n"
								+"Customer Phone: " + this.customerPhone + "\n"
								+"Sale Date: " + dateToString(this.saleDate) + "\n"
								+"Sale Cost: " + this.saleCost + "\n";
		
		return description;
	}
	public String toTaggedString() {
		String taggedDescription = "\tSALE\n"
									+"\t{\n"
									+"\t\tSALE_CODE " + this.saleCode + "\n"
									+"\t\tSALE_DEVICE_CODE " + this.saleDevice.getCode() + "\n"
									+"\t\tCUSTOMER_NAME " + this.customerName + "\n"
									+"\t\tCUSTOMER_SURNAME " + this.customerSurname + "\n"
									+"\t\tCUSTOMER_PHONE " + this.customerPhone + "\n"
									+"\t\tSALE_DATE " + dateToString(this.saleDate) + "\n"
									+"\t\tSALE_COST " + this.saleCost + "\n"
									+"\t}\n";
		
		return taggedDescription;
	}

}