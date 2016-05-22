package geopetro.exercise2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EShopDemo {
	
	private static final String productsFile = "E:\\Development\\Repos\\Java\\ConsoleApp\\src\\geopetro\\exercise2\\Products.txt";
	private static final String ordersFile = "E:\\Development\\Repos\\Java\\ConsoleApp\\src\\geopetro\\exercise2\\Orders.txt";
	private static final String salesFile = "E:\\Development\\Repos\\Java\\ConsoleApp\\src\\geopetro\\exercise2\\Sales.txt";
	
	public static void main(String[] args) {
		//Initialize the three catalogs
		CatalogLoader.loadProductsCatalog(productsFile);
		CatalogLoader.loadOrdersCatalog(ordersFile);
		CatalogLoader.loadSalesCatalog(salesFile);
		
		printMainMenu();
		
		int mainMenuChoice = readInt("Enter your choice: ",1,5);
		
		while(mainMenuChoice != 5) {
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
						
						if(CatalogLoader.productsCatalog.get(selectedDevice) > 0) { //If there are available items of the selected device then sale it
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
					mainMenuChoice = readInt("Enter your choice: ",1,5);
					break;
				case 2:
					System.out.println("\n");
					
					if(CatalogLoader.ordersCatalog.isEmpty()) {
						System.out.println("No orders on record!");
					} else {
						System.out.println("------------------------");
						System.out.println("EShop - Orders List Menu");
						System.out.println("------------------------");
						
						int i = 0;
						Iterator<Order> it = CatalogLoader.ordersCatalog.iterator();
						while(it.hasNext()) {
							Order anOrder = it.next();
							System.out.println(++i + ". Order Code: " + anOrder.getOrderCode() + "  Order Device: " + anOrder.getOrderDevice().getModelName());
						}
						
						int orderChoice = readInt("Enter your choice: ",1,CatalogLoader.ordersCatalog.size());
						Order selectedOrder = CatalogLoader.ordersCatalog.get(orderChoice-1);
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
					mainMenuChoice = readInt("Enter your choice: ",1,5);
					break;
				case 3:
					System.out.println("\n");
					
					if(CatalogLoader.salesCatalog.isEmpty()) {
						System.out.println("No sales on record!");
					} else {
						System.out.println("-----------------------");
						System.out.println("EShop - Sales List Menu");
						System.out.println("-----------------------");
						
						int i = 0;
						Iterator<Sale> it = CatalogLoader.salesCatalog.iterator();
						while(it.hasNext()) {
							Sale aSale = it.next();
							System.out.println(++i + ". Sale Code: " + aSale.getSaleCode() + "  Sale Device: " + aSale.getSaleDevice().getModelName());
						}
						
						int saleChoice = readInt("Enter your choice: ",1,CatalogLoader.salesCatalog.size());
						Sale selectedSale = CatalogLoader.salesCatalog.get(saleChoice-1);
						System.out.println("\n");
						System.out.println(selectedSale.toString());
					}
					
					System.out.println("\n");
					printMainMenu();
					mainMenuChoice = readInt("Enter your choice: ",1,5);
					break;
				case 4:
					CatalogWriter.writeOrdersCatalog(CatalogLoader.ordersCatalog,ordersFile);
					CatalogWriter.writeSalesCatalog(CatalogLoader.salesCatalog,salesFile);
					mainMenuChoice = 5; //Exit application
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
		System.out.println("4. Save & Exit");
		System.out.println("5. Exit Without Saving");
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
		
		Enumeration<Device> k = CatalogLoader.productsCatalog.keys();
		
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
		Date saleDate = readDate("Enter sale date (dd.MM.YYYY): ");
		Double saleCost = aDevice.getPrice() - (aDevice.getPrice()*aDevice.getDiscount());
		
		//Update device items available
		CatalogLoader.productsCatalog.put(aDevice, CatalogLoader.productsCatalog.get(aDevice)-1);
		
		//Add the sale to the sales catalog
		CatalogLoader.salesCatalog.add(new Sale(CatalogLoader.saleCode,aDevice,customerName,customerSurname,customerPhone,saleDate,saleCost));
		
		//Increment the sale code
		CatalogLoader.saleCode++;
		
		System.out.println("Device sold!");
	}
	
	public static void orderDevice(Device aDevice) {
		String customerName = readLine("Enter customer name: ");
		String customerSurname = readLine("Enter customer surname: ");
		String customerPhone = readLine("Enter customer phone: ");
		Date orderDate = readDate("Enter order date (dd.MM.YYYY): ");
		Date orderETA = readDate("Enter estimated date of arrival (dd.MM.YYYY): ");
		Double orderCost = aDevice.getPrice() - (aDevice.getPrice()*aDevice.getDiscount());
		
		//Add the order to the orders catalog
		CatalogLoader.ordersCatalog.add(new Order(CatalogLoader.orderCode,aDevice,customerName,customerSurname,customerPhone,orderDate,orderETA,orderCost,Constants.ORDER_STATUS_IN_PROGRESS));
		
		//Increment the order code
		CatalogLoader.orderCode++;
		
		System.out.println("Device ordered!");
	}
	
	public static void checkoutOrder(Order anOrder) {
		CatalogLoader.ordersCatalog.get(CatalogLoader.ordersCatalog.indexOf(anOrder)).setOrderStatus(Constants.ORDER_STATUS_COMPLETED);
		CatalogLoader.salesCatalog.add(new Sale(CatalogLoader.saleCode,anOrder.getOrderDevice(),anOrder.getCustomerName(),anOrder.getCustomerSurname(),anOrder.getCustomerPhone(),new Date(),anOrder.getOrderCost()));
		
		//Increment the sale code
		CatalogLoader.saleCode++;
		
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
	
	public static Date readDate(String prompt) {
		String text = "";
		
		do {
			System.out.print(prompt);
			
			try {
				Scanner sc = new Scanner(System.in);
				text = sc.next("^([1-9]{1}|1\\d{1}|2\\d{1}|3[01]{1})\\.([1-9]{1}|1[012]{1})\\.2[0-9]{3}$"); //Pattern to match a date in the format dd.MM.YYYY
			}
			catch(Exception e) {
				System.out.println("Invalid input. Try again.");
			}
		} while(text.equals(""));
		
		StringTokenizer st = new StringTokenizer(text,".");
		int[] date_parts = new int[3];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			date_parts[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		GregorianCalendar cal = new GregorianCalendar(date_parts[2],date_parts[1]-1,date_parts[0]);
		
		return cal.getTime();
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