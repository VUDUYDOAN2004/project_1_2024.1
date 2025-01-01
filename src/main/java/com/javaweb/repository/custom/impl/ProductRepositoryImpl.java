package com.javaweb.repository.custom.impl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.model.ProductDTO;
import com.javaweb.repository.ProductRepository;
import com.javaweb.repository.custom.ProductRepositoryCustom;
import com.javaweb.repository.entity.ProductEntity;
import com.javaweb.utils.ConnectorJDBC;
// Xu ly truy van database
@Repository
public  class ProductRepositoryImpl implements ProductRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductEntity> findByName(String name) {
		StringBuilder sql = new StringBuilder("select * from products where product_name like '%"+name+"%'");
		Query query = entityManager.createNativeQuery(sql.toString(), ProductEntity.class);
//		List<ProductEntity> products = new ArrayList<>();
//		try(Connection conn = ConnectorJDBC.getConnection(); ) { 
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql.toString());
//			while(rs.next()) {
//				ProductEntity product = new ProductEntity();
//				product.setProductName(rs.getNString("ProductName"));
//				product.setDescription(rs.getNString("Description"));
//				product.setPrice(rs.getInt("Price"));
//				product.setImageURL(rs.getNString("ImageURL"));
//				
//				products.add(product);
//			}
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
		return query.getResultList();
//		products = query.getResultList();
//		return products;
		
	}

	@Override
	public List<ProductEntity> findByCategory(String category) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from products p join category c on p.category_id = c.category_id "
				+ "where category_name = '"+category+"'");
		Query query = entityManager.createNativeQuery(sql.toString(), ProductEntity.class);
	
		return query.getResultList();
	}

	@Override
	public List<ProductEntity> findByPrice(BigDecimal minprice, BigDecimal maxprice) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from products "
				+ "where price >= "+minprice+" and price <= "+maxprice+" "
						+ "order by price");
		Query query = entityManager.createNativeQuery(sql.toString(), ProductEntity.class);
	
		return query.getResultList();
	}

	@Override
	public List<ProductEntity> findBySize(String size) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from products p "
				+ "join productsizes ps on p.product_id = ps.product_id "
				+ "join sizes s on s.size_id = ps.size_id "
				+ "where s.size_name = '"+ size +"' ");
		Query query = entityManager.createNativeQuery(sql.toString(), ProductEntity.class);
	
		return query.getResultList();
	}

	@Override
	public List<ProductEntity> findByFilter(BigDecimal minprice, BigDecimal maxprice, String size) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select *  from products p "
				+ "join  productsizes ps on p.product_id = ps.product_id "
				+ "join sizes s on s.size_id = ps.size_id "
				+ "where p.price >= "+minprice+" and p.price <= "+maxprice+" and s.size_name = '"+size+"' ");
		
		Query query = entityManager.createNativeQuery(sql.toString(), ProductEntity.class);
	
		return query.getResultList();
	}
	
	
	
	

	
	
	
}
