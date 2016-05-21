package geopetro.exercise1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class EShopDemo {
	
	private static Hashtable<Device, Integer> availabilityCatalog;
	private static ArrayList<Order> ordersCatalog;
	private static ArrayList<Sale> salesCatalog;
	
	//Next available codes for orders and sales
	private static Integer orderCode = 50000;
	private static Integer saleCode = 50000;
	
	public static void main(String[] args) {
		//Initialize the three catalogs
		availabilityCatalog = new Hashtable<Device, Integer>();
		ordersCatalog = new ArrayList<Order>();
		salesCatalog = new ArrayList<Sale>();
		
		//Add available devices
		availabilityCatalog.put(new TV("39203","LG 42LE8500",2010,"LG",1100.0,Constants.VISUALAUDIO_CAT,Constants.TV_SUB_CAT,0.25,Constants.LED,"42\"","1920x1080",new String[] {"HDMI","DVI","RGB","COMPONENT","USB"}), 3);
		availabilityCatalog.put(new TV("37233","LG 37LE5500",2010,"LG",800.0,Constants.VISUALAUDIO_CAT,Constants.TV_SUB_CAT,0.25,Constants.LED,"37\"","1920x1080",new String[] {"HDMI","DVI","RGB","COMPONENT","USB"}), 2);
		availabilityCatalog.put(new TV("33313","LG 32LE4500",2009,"LG",650.0,Constants.VISUALAUDIO_CAT,Constants.TV_SUB_CAT,0.25,Constants.LED,"32\"","1920x1080",new String[] {"HDMI","DVI","RGB","COMPONENT","USB"}), 0);
		
		printMainMenu();
		
		int mainMenuChoice = readInt("Enter your choice: ",1,4);
		
		while(mainMenuChoice != 4) {
			switch(mainMenuChoice) {
				case 1:
					System.out.println("\n");
					
					printDevicesMenu();
					int devicesMenuChoice = readInt("Enter your choice: ",1,3);
					int deviceSubCat = -1;
					switch(devicesMenuChoice) {
						case 1:
							System.out.println("\n");
							printVisualAudioDevicesMenu();
							deviceSubCat = readInt("Enter your choice: ",1,3);
							break;
						case 2:
							System.out.println("\n");
							printGamingDevicesMenu();
							deviceSubCat = readInt("Enter your choice: ",1,1);
							break;
						case 3:
							System.out.println("\n");
							printHomeAppliancesDevicesMenu();
							deviceSubCat = readInt("Enter your choice: ",1,2);
							break;
					}
					
					ArrayList<Device> devices = filterDevices(devicesMenuChoice,deviceSubCat);
					
					if(devices.isEmpty()) {
						System.out.println("\n");
						System.out.println("No devices found!");
					} else {
						System.out.println("\n");
						printFilteredDevicesMenu(devices);
						int deviceChoice = readInt("Enter your choice: ",1,devices.size());
						Device selectedDevice = devices.get(deviceChoice-1);
						System.out.println("\n");
						System.out.println(selectedDevice.toString());
						
						if(availabilityCatalog.get(selectedDevice) > 0) { //If there are available items of the selected device then sale it
							System.out.println("Proceed with sale ?");
							int saleChoice = readInt("Enter your choice (0|1): ",0,1);
							if(saleChoice == 1) {
								saleDevice(selectedDevice);
							}
						} else { //If there are no available items of the selected device then order it
							System.out.println("Order the device ?");
							int orderChoice = readInt("Enter your choice (0|1): ",0,1);
							if(orderChoice == 1) {
								orderDevice(selectedDevice);
							}
						}
					}
					
					System.out.println("\n");
					printMainMenu();
					mainMenuChoice = readInt("Enter your choice: ",1,4);
					break;
				case 2:
					System.out.println("\n");
					
					if(ordersCatalog.isEmpty()) {
						System.out.println("No orders on record!");
					} else {
						System.out.println("------------------------");
						System.out.println("EShop - Orders List Menu");
						System.out.println("------------------------");
						
						int i = 0;
						Iterator<Order> it = ordersCatalog.iterator();
						while(it.hasNext()) {
							Order anOrder = it.next();
							System.out.println(++i + ". Order Code: " + anOrder.getOrderCode() + "  Order Device: " + anOrder.getOrderDevice().getModelName());
						}
						
						int orderChoice = readInt("Enter your choice: ",1,ordersCatalog.size());
						Order selectedOrder = ordersCatalog.get(orderChoice-1);
						System.out.println("\n");
						System.out.println(selectedOrder.toString());
						
						if(!selectedOrder.getOrderStatus().equals(Constants.ORDER_STATUS_COMPLETED)) {
							System.out.println("\n");
							System.out.println("Checkout Order ?");
							int checkoutChoice = readInt("Enter your choice (0|1): ",0,1);
							if(checkoutChoice == 1) {
								checkoutOrder(selectedOrder);
							}
						}
					}
					
					System.out.println("\n");
					printMainMenu();
					mainMenuChoice = readInt("Enter your choice: ",1,4);
					break;
				case 3:
					System.out.println("\n");
					
					if(salesCatalog.isEmpty()) {
						System.out.println("No sales on record!");
					} else {
						System.out.println("-----------------------");
						System.out.println("EShop - Sales List Menu");
						System.out.println("-----------------------");
						
						int i = 0;
						Iterator<Sale> it = salesCatalog.iterator();
						while(it.hasNext()) {
							Sale aSale = it.next();
							System.out.println(++i + ". Sale Code: " + aSale.getSaleCode() + "  Sale Device: " + aSale.getSaleDevice().getModelName());
						}
						
						int saleChoice = readInt("Enter your choice: ",1,salesCatalog.size());
						Sale selectedSale = salesCatalog.get(saleChoice-1);
						System.out.println("\n");
						System.out.println(selectedSale.toString());
					}
					
					System.out.println("\n");
					printMainMenu();
					mainMenuChoice = readInt("Enter your choice: ",1,4);
					break;
			}
		}
		
		System.out.println("\n");
		System.out.println("Thank you for using the Eshop application, bye bye!");
		System.exit(0);
	}
	
	private static void printMainMenu() {
		System.out.println("-----------------");
		System.out.println("EShop - Main Menu");
		System.out.println("-----------------");
		System.out.println("1. Show Devices");
		System.out.println("2. Show Orders");
		System.out.println("3. Show Sales");
		System.out.println("4. Exit");
	}
	
	private static void printDevicesMenu() {
		System.out.println("------------------------------");
		System.out.println("EShop - Device Categories Menu");
		System.out.println("------------------------------");
		System.out.println("1. Visual-Audio");
		System.out.println("2. Gaming");
		System.out.println("3. Home Appliances");
	}
	
	private static void printVisualAudioDevicesMenu() {
		System.out.println("-------------------------");
		System.out.println("EShop - Device Types Menu");
		System.out.println("-------------------------");
		System.out.println("1. TV");
		System.out.println("2. Player");
		System.out.println("3. Camera");
	}
	
	private static void printGamingDevicesMenu() {
		System.out.println("-------------------------");
		System.out.println("EShop - Device Types Menu");
		System.out.println("-------------------------");
		System.out.println("1. Console");
	}
	
	private static void printHomeAppliancesDevicesMenu() {
		System.out.println("-------------------------");
		System.out.println("EShop - Device Types Menu");
		System.out.println("-------------------------");
		System.out.println("1. Fridge");
		System.out.println("2. Washing Machine");
	}
	
	private static void printFilteredDevicesMenu(ArrayList<Device> devices) {
		System.out.println("------------------------");
		System.out.println("EShop - Device List Menu");
		System.out.println("------------------------");
		
		int i = 0;
		Iterator<Device> it = devices.iterator();
		while(it.hasNext()) {
			Device aDevice = it.next();
			System.out.println(++i + ". " + aDevice.getModelName());
		}
	}
	
	public static ArrayList<Device> filterDevices(int cat, int subCat) {
		ArrayList<Device> devices = new ArrayList<Device>();
		
		Enumeration<Device> k = availabilityCatalog.keys();
		
		while(k.hasMoreElements()) {
			Device aKey = (Device) k.nextElement();
			
			if((aKey.getCategory().intValue()==cat) && (aKey.getSubCategory().intValue()==subCat)) {
				devices.add(aKey);
			}
		}
		
		return devices;
	}
	
	public static void saleDevice(Device aDevice) {
		String customerName = readLine("Enter customer name: ");
		String customerSurname = readLine("Enter customer surname: ");
		String customerPhone = readLine("Enter customer phone: ");
		//String saleDate = readLine("Enter sale date: ");
		Double saleCost = aDevice.getPrice() - (aDevice.getPrice()*aDevice.getDiscount());
		
		//Update device items available
		availabilityCatalog.put(aDevice, availabilityCatalog.get(aDevice)-1);
		
		//Add the sale to the sales catalog
		salesCatalog.add(new Sale(saleCode,aDevice,customerName,customerSurname,customerPhone,new Date(),saleCost));
		
		//Increment the sale code
		saleCode++;
		
		System.out.println("Device sold!");
	}
	
	public static void orderDevice(Device aDevice) {
		String customerName = readLine("Enter customer name: ");
		String customerSurname = readLine("Enter customer surname: ");
		String customerPhone = readLine("Enter customer phone: ");
		//String orderETA = readLine("Enter estimated time of arrival: ");
		Double orderCost = aDevice.getPrice() - (aDevice.getPrice()*aDevice.getDiscount());
		
		//Add the order to the orders catalog
		ordersCatalog.add(new Order(orderCode,aDevice,customerName,customerSurname,customerPhone,new Date(),new Date(),orderCost,Constants.ORDER_STATUS_IN_PROGRESS));
		
		//Increment the order code
		orderCode++;
		
		System.out.println("Device ordered!");
	}
	
	public static void checkoutOrder(Order anOrder) {
		ordersCatalog.get(ordersCatalog.indexOf(anOrder)).setOrderStatus(Constants.ORDER_STATUS_COMPLETED);
		salesCatalog.add(new Sale(saleCode,anOrder.getOrderDevice(),anOrder.getCustomerName(),anOrder.getCustomerSurname(),anOrder.getCustomerPhone(),new Date(),anOrder.getOrderCost()));
		
		//Increment the sale code
		saleCode++;
		
		System.out.println("Checkout completed!");
	}
	
	public static int readInt(String prompt, int low, int max) {
		int aNumber;
		
		do {
			aNumber = Integer.MIN_VALUE;
			
			System.out.print(prompt);
			
			try {
				Scanner sc = new Scanner(System.in);
				aNumber = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid input. Try again.");
			}
			
			if((aNumber!=Integer.MIN_VALUE) && (aNumber<low || aNumber>max)) {
				System.out.println("Input out of range. Try again.");
			}
		} while((aNumber==-1) || (aNumber<low || aNumber>max));
		
		return aNumber;
	}
	
	public static String readLine(String prompt) {
		String text = "";
		
		do {
			System.out.print(prompt);
			
			try {
				Scanner sc = new Scanner(System.in);
				text = sc.nextLine();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
		} while(text.equals(""));
		
		return text;
	}

}