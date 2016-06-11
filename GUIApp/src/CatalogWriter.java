import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class CatalogWriter {
	
	public static void writeProductsCatalog(Hashtable<Product, Integer> productsCatalog, String filePath){
		String productData = "ITEM_LIST\n{\n";
		
		Product aProduct;
		ArrayList<Product> product = new ArrayList<Product>();
		
		Enumeration<Product> k = CatalogLoader.productsCatalog.keys();
		
		while(k.hasMoreElements()) {
			Product aKey = (Product) k.nextElement();
			product.add(aKey);
		}
		
		for(int i = 0; i < product.size(); i++){
			product.get(i).setQuantity(CatalogLoader.productsCatalog.get(product.get(i)));
		}
		
		Iterator<Product> productsIterator = product.iterator();
		while(productsIterator.hasNext()) {
			aProduct = productsIterator.next();
			productData += aProduct.printTaggedDescription();
		}
		productData += "}";
		
		writeCatalogFile(filePath,productData);
		
	}
	public static void writeOrdersCatalog(ArrayList<Order> ordersCatalog, String filePath){
		String orderData = "ORDER_LIST\n{\n";
		
		Order anOrder;
		Iterator<Order> ordersIterator = ordersCatalog.iterator();
		while(ordersIterator.hasNext()) {
			anOrder = ordersIterator.next();
			orderData += anOrder.printTaggedDescription();
		}
		orderData += "}";
		
		writeCatalogFile(filePath,orderData);
		
	}
	
	public static void writeSalesCatalog(ArrayList<Sale> salesCatalog, String filePath){
		String saleData = "SALE_LIST\n{\n";
		
		Sale aSale;
		Iterator<Sale> salesIterator = salesCatalog.iterator();
		while(salesIterator.hasNext()) {
			aSale = salesIterator.next();
			saleData += aSale.printTaggedDescription();
		}
		saleData += "}";
		
		writeCatalogFile(filePath,saleData);
		
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
