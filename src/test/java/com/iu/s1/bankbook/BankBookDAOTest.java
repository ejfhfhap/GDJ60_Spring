package com.iu.s1.bankbook;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	@Autowired
	BankBookDAO bankBookDAO;
	@Autowired
	BankBookService bankBookService;
	
//	@Test
//	public void getBankBookList() throws Exception {
//		//List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//	//	assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	public void getBankBookDetail() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(23);
//
//		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
//		
//		assertNotNull(bankBookDTO);
//	}
	
	@Test
	public void setBankBookAdd() throws Exception{
		
		for(int i = 1;i<30;i++) {
			Random r = new Random();
			double d = (int)(r.nextDouble() * 1000);
			d/=100;
			
			BankBookDTO bookDTO = new BankBookDTO();
			bookDTO.setBookName("주형적금" + i);
			bookDTO.setBookRate(d);
			bookDTO.setBookSale(1);
			bookDTO.setBookDetail("dlwngud");
			
		//	int result = bankBookService.setBankBookAdd(bookDTO);
		//	assertNotEquals(1, result);
		}
	}
	
//	@Test
//	public void setBankBookUpdate() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookDetail("dsfsd");
//		bankBookDTO.setBookName("이주형");
//		bankBookDTO.setBookNumber(2);
//		bankBookDTO.setBookRate(3.2);
//		bankBookDTO.setBookSale(1);
//		
//		int result = bankBookDAO.setBankBookUpdate(bankBookDTO);
//		assertNotEquals(0, result);
//	}
//	
//	@Test
//	public void setBankBookDelete() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(23);
//		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
//		assertNotEquals(0, result);
//	}
}
