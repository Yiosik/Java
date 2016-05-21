package geopetro.exercise2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class CatalogWriter {
	
	public static void writeOrdersCatalog(ArrayList<Order> ordersCatalog, String filePath){
		String orderData = "ORDER_LIST\n{\n";
		
		Order anOrder;
		Iterator<Order> ordersIterator = ordersCatalog.iterator();
		while(ordersIterator.hasNext()) {
			anOrder = ordersIterator.next();
			orderData += anOrder.toTaggedString();
		}
		orderData += "}";
		
		writeCatalogFile(filePath,orderData);
		
		/* Diagnostic Purposes
		System.out.println("\n");
		System.out.println("ORDER DATA");
		System.out.println("----------");
		System.out.println(orderData);
		*/
	}
	
	public static void writeSalesCatalog(ArrayList<Sale> salesCatalog, String filePath){
		String saleData = "SALE_LIST\n{\n";
		
		Sale aSale;
		Iterator<Sale> salesIterator = salesCatalog.iterator();
		while(salesIterator.hasNext()) {
			aSale = salesIterator.next();
			saleData += aSale.toTaggedString();
		}
		saleData += "}";
		
		writeCatalogFile(filePath,saleData);
		
		/* Diagnostic Purposes
		System.out.println("\n");
		System.out.println("SALE DATA");
		System.out.println("---------");
		System.out.println(saleData);
		*/
	}
	
    public static void writeCatalogFile(String filePath, String data) {
        try {
        	BufferedWriter os = new BufferedWriter(new FileWriter(filePath));
            os.write(data);
            os.flush();
            os.close();
            
            System.out.println("\n");
            System.out.println("Catalog file " + filePath + " saved successfully!");
        } catch(Exception e) {
        	System.out.println("\n");
        	System.out.println("Error saving file " + filePath + " - " + e.toString());
        }
    }
}
