package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	// test할때는 주석해야됨!!
//	@Autowired
//	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception{


		// 리스트 전체갯수
		int totalCount = bankBookDAO.getBankBookCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return bankBookDAO.getBankBookList(pager);
	}
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO)throws Exception {
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO, HttpSession session,MultipartFile pic)throws Exception {
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		// 파일이 없을때
		// if(!pic.isEmpty())
		if(pic.getSize() != 0) {
	//		1. file을 서버 hdd에 저장 프로젝트 경로x os경로로 잡음
			
			ServletContext servletContext = session.getServletContext();
			String realPath = servletContext.getRealPath("resources/upload/bankBook");
			
			System.out.println(realPath);
			String fileName = fileManager.fileSave(pic, realPath);
			
			BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
			bankBookImgDTO.setFileName(fileName);
			bankBookImgDTO.setOriName(pic.getOriginalFilename());
			bankBookImgDTO.setBookNumber(bankBookDTO.getBookNumber());
			
			result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
		}
		
		return result; 
	}
	public int setBankBookUpdate(BankBookDTO bankBookDTO)throws Exception {
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	public int setBankBookDelete(BankBookDTO bankBookDTO)throws Exception {
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
}
