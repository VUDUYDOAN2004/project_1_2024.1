package com.javaweb.repository.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.model.ProductDTO;
import com.javaweb.repository.ProductRepository;
import com.javaweb.repository.entity.ProductEntity;
import com.javaweb.utils.ConnectorJDBC;
// Xu ly truy van database
@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from products");
		List<ProductEntity> products = new ArrayList<>();
		try(Connection conn = ConnectorJDBC.getConnection(); ) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				ProductEntity product = new ProductEntity();
				product.setProductName(rs.getNString("ProductName"));
				product.setDescription(rs.getNString("Description"));
				product.setPrice(rs.getInt("Price"));
				product.setImageURL(rs.getNString("ImageURL"));
				
				products.add(product);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return products;
	}

	
	

	
	
	
}
