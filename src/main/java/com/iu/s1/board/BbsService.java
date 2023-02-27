package com.iu.s1.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.Pager;

public interface BbsService {
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	public int setBoardAdd(BbsDTO bbsDTO)throws Exception;
	public int setBoardAdd(BbsDTO bbsDTO,MultipartFile[] files, HttpSession session)throws Exception;
	public int setBoardUpdate(BbsDTO bbsDTO)throws Exception;
	public int setBoardDelete(BbsDTO bbsDTO)throws Exception;
}
