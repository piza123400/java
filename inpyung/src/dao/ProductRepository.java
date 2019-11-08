package dao;

import java.util.ArrayList;

import dto.Product;

public class ProductRepository {
	
	private ArrayList<Product> listOProducts = new ArrayList<Product>();
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance(){
		return instance;
		
		
		
	}
	
	public ProductRepository(){
		Product phone = new Product("P1234","Phio1e",234234234);
		phone.setDescription("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		phone.setCategory("P1234");
		phone.setManufacturer("P1234");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
	//	phone.setFilename("P1234.jpg");
		
		
		Product notebook = new Product("P1123234","Phi2oe",234234234);
		notebook.setDescription("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		notebook.setCategory("P1123234");
		notebook.setManufacturer("P1234");
		notebook.setUnitsInStock(11000);
		notebook.setCondition("refurbished");
		//notebook.setFilename("P123.jpg");
		
		Product tablet = new Product("P1123234","Phi3oe",234234234);
		tablet.setDescription("ccccccccccccccccccccccccccccccccccc");
		tablet.setCategory("P1123234");
		tablet.setManufacturer("P1123234");
		tablet.setUnitsInStock(101100);
		//tablet.setFilename("P12.jpg");

		listOProducts.add(phone);
		listOProducts.add(notebook);
		listOProducts.add(tablet);
		
		
		
		
	}
	public void addProduct(Product product){
		
		listOProducts.add(product);
		
	}	
	
	public ArrayList<Product>getAllProducts(){
		return listOProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
	
	
	for(int i = 0;i<listOProducts.size();i++){
		Product product = listOProducts.get(i);
		if(product!=null && product.getProductId() != null && product.getProductId().equals(productId)){
			productById = product;
			break;
		}
	}
	
	return productById;
	
	}
	
}
