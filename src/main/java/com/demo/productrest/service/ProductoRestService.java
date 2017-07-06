package com.demo.productrest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.productrest.bean.Product;

@Path("/products")
public class ProductoRestService {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Product> getCountries()
	{
		List<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts=createProductList();
		return listOfProducts;
	}

	@GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") int id)
	{
		List<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts=createProductList();

		for (Product product: listOfProducts) {
			if(product.getId()==id)
				return product;
		}
		
		return null;
	}

// Utiliy method to create country list.
	public List<Product> createProductList()
	{
		Product carlosV=new Product(1, "Carlos V");
		Product tinLarin=new Product(4, "Tin - Larin");
		Product kiss=new Product(3, "Kiss");
		Product sneakers=new Product(2, "Sneakers");

		List<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts.add(carlosV);
		listOfProducts.add(tinLarin);
		listOfProducts.add(kiss);
		listOfProducts.add(sneakers);
		return listOfProducts;
	}
}

