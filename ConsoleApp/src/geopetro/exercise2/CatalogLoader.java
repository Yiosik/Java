package geopetro.exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class CatalogLoader {
	
	private static final int PRODUCTS_CATALOG_TYPE = 1;
	private static final int ORDERS_CATALOG_TYPE = 2;
	private static final int SALES_CATALOG_TYPE = 3;
	
	//Next available codes for orders and sales
	public static Integer orderCode = 50000;
	public static Integer saleCode = 50000;
	
	public static Hashtable<Device, Integer> productsCatalog;
	public static ArrayList<Order> ordersCatalog;
	public static ArrayList<Sale> salesCatalog;

	public static void loadProductsCatalog(String filePath){
		productsCatalog =  new Hashtable<Device, Integer>();
		
		ArrayList<Hashtable<String, String>> items = readCatalogFile(filePath,PRODUCTS_CATALOG_TYPE);
		Hashtable<String, String> anItem;
		
		Iterator<Hashtable<String, String>> itemsIterator = items.iterator();
		while(itemsIterator.hasNext()) {
			anItem = (Hashtable<String, String>)itemsIterator.next();
			
			if(!anItem.containsKey("ITEM_CAT")
					|| !anItem.containsKey("ITEM_SUB_CAT")
					|| !anItem.containsKey("CODE")
					|| !anItem.containsKey("MODEL_NAME")) {
				System.out.println("Item missing required information found. Item ignored!");
			} else {
				int anItemCat = Integer.parseInt(anItem.get("ITEM_CAT"));
				int anItemSubCat = Integer.parseInt(anItem.get("ITEM_SUB_CAT"));
				
				switch(anItemCat) {
					case 1:
						switch(anItemSubCat) {
							case 1:
								TV aTV = new TV(anItem.get("CODE"),
												anItem.get("MODEL_NAME"),
												Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
												getAttributeValue(anItem,"MANUFACTURER","N/A"),
												Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
												Integer.valueOf(anItemCat),
												Integer.valueOf(anItemSubCat),
												Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
												getAttributeValue(anItem,"ITEM_TYPE","N/A"),
												getAttributeValue(anItem,"SCREEN_SIZE","N/A"),
												getAttributeValue(anItem,"RESOLUTION","N/A"),
												getTokens(getAttributeValue(anItem,"PORTS","N/A")));
								
								productsCatalog.put(aTV, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
							case 2:
								Player aPlayer = new Player(anItem.get("CODE"),
															anItem.get("MODEL_NAME"),
															Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
															getAttributeValue(anItem,"MANUFACTURER","N/A"),
															Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
															Integer.valueOf(anItemCat),
															Integer.valueOf(anItemSubCat),
															Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
															getAttributeValue(anItem,"ITEM_TYPE","N/A"),
															getAttributeValue(anItem,"RESOLUTION","N/A"),
															getTokens(getAttributeValue(anItem,"MEDIA_FORMAT","N/A")));
								
								productsCatalog.put(aPlayer, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
							case 3:
								Camera aCamera = new Camera(anItem.get("CODE"),
															anItem.get("MODEL_NAME"),
															Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
															getAttributeValue(anItem,"MANUFACTURER","N/A"),
															Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
															Integer.valueOf(anItemCat),
															Integer.valueOf(anItemSubCat),
															Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
															getAttributeValue(anItem,"ITEM_TYPE","N/A"),
															getAttributeValue(anItem,"MEGAPIXEL","N/A"),
															getAttributeValue(anItem,"OPTICAL_ZOOM","N/A"),
															getAttributeValue(anItem,"DIGITAL_ZOOM","N/A"),
															getAttributeValue(anItem,"SCREEN_SIZE","N/A"));
								
								productsCatalog.put(aCamera, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
						}
						break;
					case 2:
						switch(anItemSubCat) {
							case 1:
								Console aConsole = new Console(anItem.get("CODE"),
																anItem.get("MODEL_NAME"),
																Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
																getAttributeValue(anItem,"MANUFACTURER","N/A"),
																Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
																Integer.valueOf(anItemCat),
																Integer.valueOf(anItemSubCat),
																Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
																getAttributeValue(anItem,"ITEM_TYPE","N/A"),
																getAttributeValue(anItem,"PROCESSOR","N/A"),
																getAttributeValue(anItem,"GRAPHICS","N/A"),
																getAttributeValue(anItem,"SOUND","N/A"),
																getAttributeValue(anItem,"STORAGE_CAPACITY","N/A"));
								
								productsCatalog.put(aConsole, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
						}
						break;
					case 3:
						switch(anItemSubCat) {
							case 1:
								Fridge aFridge = new Fridge(anItem.get("CODE"),
															anItem.get("MODEL_NAME"),
															Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
															getAttributeValue(anItem,"MANUFACTURER","N/A"),
															Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
															Integer.valueOf(anItemCat),
															Integer.valueOf(anItemSubCat),
															Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
															getAttributeValue(anItem,"ITEM_TYPE","N/A"),
															getAttributeValue(anItem,"ENERGY_CLASS","N/A"),
															getAttributeValue(anItem,"REFRIGERATOR_CAPACITY","N/A"),
															getAttributeValue(anItem,"FREEZER_CAPACITY","N/A"));
								
								productsCatalog.put(aFridge, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
							case 2:
								WashingMachine aWashingMachine = new WashingMachine(anItem.get("CODE"),
																					anItem.get("MODEL_NAME"),
																					Integer.valueOf(getAttributeValue(anItem,"MODEL_YEAR","1970")),
																					getAttributeValue(anItem,"MANUFACTURER","N/A"),
																					Double.valueOf(getAttributeValue(anItem,"PRICE","0.0")),
																					Integer.valueOf(anItemCat),
																					Integer.valueOf(anItemSubCat),
																					Double.valueOf(getAttributeValue(anItem,"DISCOUNT","0.0")),
																					getAttributeValue(anItem,"ENERGY_CLASS","N/A"),
																					getAttributeValue(anItem,"CAPACITY","N/A"),
																					getAttributeValue(anItem,"SPIN_SPEED","N/A"));
								
								productsCatalog.put(aWashingMachine, Integer.valueOf(getAttributeValue(anItem,"QUANTITY","0")));
								break;
						}
						break;
				}
			}
			
			/* Diagnostic Purposes
			Enumeration<String>  k = anItem.keys();
			System.out.println("*** ITEM - START ***");
			while(k.hasMoreElements()) {
				String aKey = k.nextElement();
				System.out.println(aKey + ": " + anItem.get(aKey));
			}
			System.out.println("*** ITEM - END ***");
			*/
		}
	}
	
	public static void loadOrdersCatalog(String filePath){
		ordersCatalog = new ArrayList<Order>();
		
		ArrayList<Hashtable<String, String>> orders = readCatalogFile(filePath,ORDERS_CATALOG_TYPE);
		Hashtable<String, String> anOrder;
		
		Iterator<Hashtable<String, String>> ordersIterator = orders.iterator();
		while(ordersIterator.hasNext()) {
			anOrder = ordersIterator.next();
			Device orderDevice = lookupDevice(anOrder.get("ORDER_DEVICE_CODE"));
			
			if(orderDevice == null) {
				System.out.println("Order device not included in the products catalog. Order ignored!");
			} else {
				//Adjusting the next available order code as necessary
				Integer thisOrderCode = Integer.valueOf(anOrder.get("ORDER_CODE"));
				if(thisOrderCode > orderCode) {
					orderCode = thisOrderCode+1;
				}
				
				Order o = new Order(thisOrderCode,
									orderDevice,
									anOrder.get("CUSTOMER_NAME"),
									anOrder.get("CUSTOMER_SURNAME"),
									anOrder.get("CUSTOMER_PHONE"),
									stringToDate(anOrder.get("ORDER_DATE")),
									stringToDate(anOrder.get("ORDER_ETA")),
									Double.valueOf(anOrder.get("ORDER_COST")),
									anOrder.get("ORDER_STATUS"));
				
				ordersCatalog.add(o);
			}
		}
	}
	
	public static void loadSalesCatalog(String filePath){
		salesCatalog = new ArrayList<Sale>();
		
		ArrayList<Hashtable<String, String>> sales = readCatalogFile(filePath,SALES_CATALOG_TYPE);
		Hashtable<String, String> aSale;
		
		Iterator<Hashtable<String, String>> salesIterator = sales.iterator();
		while(salesIterator.hasNext()) {
			aSale = salesIterator.next();
			Device saleDevice = lookupDevice(aSale.get("SALE_DEVICE_CODE"));
			
			if(saleDevice == null) {
				System.out.println("Sale device not included in the products catalog. Sale ignored!");
			} else {
				//Adjusting the next available sale code as necessary
				Integer thisSaleCode = Integer.valueOf(aSale.get("SALE_CODE"));
				if(thisSaleCode > saleCode) {
					saleCode = thisSaleCode+1;
				}
				
				Sale s = new Sale(thisSaleCode,
									saleDevice,
									aSale.get("CUSTOMER_NAME"),
									aSale.get("CUSTOMER_SURNAME"),
									aSale.get("CUSTOMER_PHONE"),
									stringToDate(aSale.get("SALE_DATE")),
									Double.valueOf(aSale.get("SALE_COST")));
				
				salesCatalog.add(s);
			}
		}
	}
	
	public static ArrayList<Hashtable<String, String>> readCatalogFile(String filePath, int catalogType) {
		ArrayList<Hashtable<String, String>> elementList = new ArrayList<Hashtable<String, String>>();
		
		String parentElement = "";
		String childElement = "";
		
		switch(catalogType) {
			case 1:
				parentElement = "ITEM_LIST";
				childElement = "ITEM";
				break;
			case 2:
				parentElement = "ORDER_LIST";
				childElement = "ORDER";
				break;
			case 3:
				parentElement = "SALE_LIST";
				childElement = "SALE";
				break;
		}
		
		BufferedReader is = null;
		
		try {
			is = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			line = is.readLine();
			
			String outerTag = "";
			boolean cursorInsideElement = false;
			Hashtable<String, String> anElement = new Hashtable<String, String>();
			
			while(line != null) {
				line = line.trim(); //Get rid of leading and trailing whitespace.
				line = line.replaceAll("\\p{Blank}+"," "); //Replace all spaces and tabs with a single space character (for presentation purposes).
				
				if(line.startsWith("//")) {
					//Treat it as a comment and advance a line
				} else if(line.toUpperCase().startsWith(parentElement)) {
					outerTag = parentElement;
				} else if(line.toUpperCase().endsWith(childElement)) {
					outerTag = childElement;
				} else if(line.startsWith("{")) {
					if(outerTag.equals(childElement)) {
						cursorInsideElement = true;
					}
				} else if(line.startsWith("}")) {
					if(outerTag.equals(childElement)) {
						cursorInsideElement = false;
						elementList.add(cloneHashtable(anElement));
						anElement.clear();
						outerTag = parentElement;
					}
				} else if(cursorInsideElement) {
					String[] attributeKV = line.split("\\p{Blank}+", 2); //Find the first space or tab and split the string around that.
					anElement.put(attributeKV[0].toUpperCase(),attributeKV[1]); //Store the key (attribute tag) in uppercase to overcome case differences.
				}
				
				line = is.readLine();
			}
			
			is.close();
			return elementList;
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.toString());
			return elementList;
		}
	}
	
	public static Hashtable<String, String> cloneHashtable(Hashtable<String, String> aHashtable) {
		Hashtable<String, String> clone = new Hashtable<String, String>();
		
		if(aHashtable.size() != 0) {
			Enumeration<String> k = aHashtable.keys();
			while(k.hasMoreElements()) {
				String aKey = (String)k.nextElement();
				clone.put(aKey, aHashtable.get(aKey));
			}
		}
		
		return clone;
	}
	
	public static String getAttributeValue(Hashtable<String, String> anElement, String attributeKey, String defaultValue) {
		if(anElement.containsKey(attributeKey)) {
			return anElement.get(attributeKey);
		}
		
		return defaultValue;
	}
	
	public static Device lookupDevice(String aDeviceCode) {
		Device d = null;
		
		Enumeration<Device>  devices = productsCatalog.keys();
		while(devices.hasMoreElements()) {
			Device aDevice = devices.nextElement();
			if(aDevice.getCode().equals(aDeviceCode)) {
				d = aDevice;
			}
		}
		
		return d;
	}
	
	public static Date stringToDate(String aDateString) {
		StringTokenizer st = new StringTokenizer(aDateString,".");
		int[] date_parts = new int[3];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			date_parts[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		GregorianCalendar cal = new GregorianCalendar(date_parts[2],date_parts[1]-1,date_parts[0]);
		
		return cal.getTime();
	}
	
	public static String[] getTokens(String delimetedText) {
		StringTokenizer st = new StringTokenizer(delimetedText,"|");
		int numberOfTokens = st.countTokens();
		String[] tokens = new String[numberOfTokens];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			tokens[i] = st.nextToken();
			i++;
		}
		
		return tokens;
	}
}
