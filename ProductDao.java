package com.sathya;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao 
{

	public int saveProduct(Product product)
	{
		int result=0;
		try(Connection connection=DBConnectionUtils.createConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement("insert into Product_data1 values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, product.getProdId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBinaryStream(8, product.getProImage());
			
			result = preparedStatement.executeUpdate();
			System.out.println("Data inserted dao success");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public List<Product> findAll()
	{
		
		List<Product> products=new ArrayList<Product>();
		try(Connection connection=DBConnectionUtils.createConnection())
		{
			
			Statement statement=connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from Product_data1");
			
			while(resultSet.next())
			{
				Product product=new Product();
				//get the data from resultset and set to product
				product.setProdId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setReadImage(resultSet.getBytes("proImage"));
				
				products.add(product);
				
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public int deleteProductById(String id)
	{
		int result=0;
		try(Connection connection= DBConnectionUtils.createConnection())
		{
			//create the PreparedStatement object
			PreparedStatement preparedStatement=connection.prepareStatement("delete from Product_data1 where prodId=?");
		
			//set the data to params
			preparedStatement.setString(1, id);
			
			//execute the query
			result=preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Product findById(String prodId)
	{
		Product product=null;
		try(Connection connection=DBConnectionUtils.createConnection())
		{
			//create the preparedStatement object
			PreparedStatement preparedStatement=connection.prepareStatement("select * from Product_data1 where prodId=?");
			
			//set the data to params
			preparedStatement.setString(1, prodId);
			
			//execute the query
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				product= new Product();
				product.setProdId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setReadImage(resultSet.getBytes("proImage"));
			}
			
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
	}
	
	public int updateProduct(Product updatedProduct) {
	    int result = 0;
    try(Connection connection = DBConnectionUtils.createConnection())
    {
    	int parameterIndex = 1;
         // SQL query to update product details
    	 String sql = "UPDATE Product_data1 SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
                 "proMfgDate=?, proExpDate=?" +
                 (updatedProduct.getProImage() != null ? ", proImage=?" : "") +
                 " WHERE prodId=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Set the parameters for the update statement
        preparedStatement.setString(parameterIndex++, updatedProduct.getProName());
        preparedStatement.setDouble(parameterIndex++, updatedProduct.getProPrice());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProBrand());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProMadeIn());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProMfgDate());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProExpDate());
        
        if ( updatedProduct.getProImage() != null) {
            preparedStatement.setBinaryStream(parameterIndex++, updatedProduct.getProImage());
        }
        
        preparedStatement.setString(parameterIndex++, updatedProduct.getProdId());

            // Execute the update
            result = preparedStatement.executeUpdate();
        }
     catch (SQLException e) {
        e.printStackTrace();
    } 
    return result;
	    }
}
