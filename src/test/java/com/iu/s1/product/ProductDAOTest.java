package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		
		//단정문 희망하지 않는값, 변수명
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getProductDetailTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductnum(29123);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNull(productDTO);
	}
	
	@Test
	public void setProductAdd() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductnum(22);
		productDTO.setProductname("이주형 테스트");
		productDTO.setProductdetail("설명입니다");
		productDTO.setProductjumsu(4.0);
		int result = productDAO.setProductAdd(productDTO);
		assertEquals(1, result);
	}
}
