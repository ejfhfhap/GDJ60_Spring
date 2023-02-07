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
//	public List<ProductOptionDTO> getProductOptionList() throws Exception {
//		Connection connection = dataSource.getConnection();
//		String sql = "SELECT * FROM PRODUCT_OPTION";
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		
//		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
//		while(resultSet.next()) {
//			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//			productOptionDTO.setOption_num(resultSet.getInt("OPTION_NUM"));
//			productOptionDTO.setProduct_num(resultSet.getInt("PRODUCT_NUM"));
//			productOptionDTO.setOption_name(resultSet.getString("OPTION_NAME"));
//			productOptionDTO.setOption_price(resultSet.getInt("OPTION_PRICE"));
//			productOptionDTO.setOption_each(resultSet.getInt("OPTION_EACH"));
//			ar.add(productOptionDTO);
//		}
//		DBConnection.disConnection(resultSet, preparedStatement, connection);
//		return ar;
//	}
//	public int AddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
//		Connection connection = DBConnection.getConnection();
//		String sql = "INSERT INTO PRODUCT_OPTION VALUES(PRODUCT_OPTION_SEQ.NEXTVAL,?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		preparedStatement.setInt(1, productOptionDTO.getProduct_num());
//		preparedStatement.setString(2, productOptionDTO.getOption_name());
//		preparedStatement.setInt(3, productOptionDTO.getOption_price());
//		preparedStatement.setInt(4, productOptionDTO.getOption_each());
//		
//		int result = preparedStatement.executeUpdate();
//		DBConnection.disConnection(preparedStatement, connection);
//		return result;
//		
////		private Integer option_num;
////		private Integer product_num;
////		private String option_name;
////		private Integer option_price;
////		private Integer option_each;
//	}
	
	
	public List<ProductDTO> getProductList() throws Exception{
		return sqlSession.selectList(NAMESPACE + "getProductList");
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
