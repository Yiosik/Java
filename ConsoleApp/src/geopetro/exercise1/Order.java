package geopetro.exercise1;

import java.util.Date;

public class Order {
	
	private Integer orderCode;
	private Device orderDevice;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private Date orderDate;
	private Date orderETA;
	private Double orderCost;
	private String orderStatus;
	
	public Order() {
		this.orderCode = null;
		this.orderDevice = null;
		this.customerName = null;
		this.customerSurname = null;
		this.customerPhone = null;
		this.orderDate = null;
		this.orderETA = null;
		this.orderCost = null;
		this.orderStatus = null;
	}
	
	public Order(
			Integer orderCode, Device orderDevice, String customerName,
			String customerSurname, String customerPhone, Date orderDate,
			Date orderETA, Double orderCost, String orderStatus
	) {
		this.orderCode = orderCode;
		this.orderDevice = orderDevice;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerPhone = customerPhone;
		this.orderDate = orderDate;
		this.orderETA = orderETA;
		this.orderCost = orderCost;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}
	public Device getOrderDevice() {
		return orderDevice;
	}
	public void setOrderDevice(Device orderDevice) {
		this.orderDevice = orderDevice;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderETA() {
		return orderETA;
	}
	public void setOrderETA(Date orderETA) {
		this.orderETA = orderETA;
	}
	public Double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String toString() {
		String description = "Order Description\n"
								+"-----------------\n"
								+"Order Code: " + this.orderCode + "\n"
								+"Order Device: " + this.orderDevice.getModelName() + "\n"
								+"Customer Name: " + this.customerName + "\n"
								+"Customer Surname: " + this.customerSurname + "\n"
								+"Customer Phone: " + this.customerPhone + "\n"
								+"Order Date: " + this.orderDate + "\n"
								+"Order ETA: " + this.orderETA + "\n"
								+"Order Cost: " + this.orderCost + "\n"
								+"Order Status: " + this.orderStatus + "\n";
		
		return description;
	}
	
}