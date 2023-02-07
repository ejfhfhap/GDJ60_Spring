package com.iu.s1.product;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ProductDTO productDTO) throws Exception{
		
		System.out.println("Product List");
		List<ProductDTO> ar = productServices.getProductList();
		System.out.println(ar.size()>0);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/productList"); // jsp 설정
		modelAndView.addObject("list", ar); // list 변수 jsp로 보냄 attribute랑 같은역할
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		System.out.println("Product Detail");
		
		productDTO = productServices.getProductDetail(productDTO);
		System.out.println(productDTO != null);
		model.addAttribute("dto", productDTO);
		
		return "/product/productDetail";
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public String setProductAdd() {
		// 여기는 입력 페이지
		// 자동으로 url 주소를 이용하여 jsp파일을 찾아줌 이것도 가능함
		return "product/productAdd";
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setProductAdd(ProductDTO productDTO) throws Exception {
		productDTO.setProductjumsu(1.3);
		int result = productServices.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";
	}
	
//	@RequestMapping(value = "update")
//	public ModelAndView productUpdate() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/product/productUpdate");
//		return mv;
//	}
//	
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public ModelAndView productUpdate(ProductDTO productDTO) {
//		ModelAndView modelAndView = new ModelAndView();
//		System.out.println("hihi");
//		System.out.println(productDTO.getPRODUCT_NAME());
//		modelAndView.setViewName("redirect: ./list");
//		return modelAndView;
//	}
//	
//	@RequestMapping(value = "/delete.do")
//	public ModelAndView delete() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("/product/delete");
//		return modelAndView;
//	}
}
