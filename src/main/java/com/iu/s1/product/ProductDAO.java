package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;
import com.iu.s1.util.Pager;

@Repository
public class ProductDAO {
	
	// mapp의 위치!!
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(int product_num) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setProductDelete" , product_num);
		
	}
	
	public ProductDTO getProductDetail(ProductDTO dto) throws Exception {
		// mapper이름 + mapper id 합친거임 !! 그리고 , 매개변수
		return sqlSession.selectOne(NAMESPACE + "getProductDetail", dto);
		
	}
	public int getProductNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getProductNum");
	}
	
	public List<ProductDTO> getProductList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getProductList",pager);
	}
	
	public int getProductCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getProductCount", pager);
	}
	
	public int setProductAdd(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setProductAdd", productDTO);
//		
//		private Integer item_num;
//		private String account_name;
//		private double rate;
//		private String detail;
//		private String status;
	}
	
}
