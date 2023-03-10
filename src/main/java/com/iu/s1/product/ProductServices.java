package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class ProductServices {
	
	@Autowired
	private ProductDAO productDAO;
//	@Autowired
//	private ProductOptionDTO productOptionDTO;
//	@Autowired
//	private ProductDTO productDTO;
	
	
	public List<ProductDTO> getProductList(Pager pager) throws Exception{
		int totalCount = productDAO.getProductCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return productDAO.getProductList(pager);
	}
	// 상품 하나 추가하기 서비스 클래스
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
	
		int productNum = productDAO.getProductNum();
		int result = 0;
		productDTO.setProductnum(productNum);
		productDAO.setProductAdd(productDTO);
//		if(ar!=null) {
//			for(ProductOptionDTO productOptionDTO : ar) {
//				productOptionDTO.setProduct_num(productNum);
//				result = productDAO.AddProductOption(productOptionDTO);
//			}
//		}
		return result;
	}

}
