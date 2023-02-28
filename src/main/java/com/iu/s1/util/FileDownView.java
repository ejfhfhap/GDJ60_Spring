package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;

@Component
public class FileDownView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//	System.out.println("FileDownView");
			BoardFileDTO boardFileDTO = (BoardFileDTO)model.get("boardFile");
		//	System.out.println(boardFileDTO.getFileNum());
		//	System.out.println(boardFileDTO.getFileName());
			
			// model에 있는 key 출력하기
//			Iterator<String> it = model.keySet().iterator();
//			while(it.hasNext()) {
//				String key = it.next();
//				System.out.println(key);
//			}
			// key : boardName, boardFile
			
			// 경로 준비 끝
			String path = (String) model.get("boardName");
			path = "resources/upload/" + path + "/";
			path = request.getSession().getServletContext().getRealPath(path);
			
			// 파일 객체 만들기 file 객체 만들때 parent: string으로 해도 됨
			File file = new File(path, boardFileDTO.getFileName());
			
			// 응답시 한글 Encoding 처리
			response.setCharacterEncoding("UTF-8");
			
			//응답시 파일 크기 보내줌 (파일 다운로드 몇분 남았는지 확인) 파일크기 매개변수
			response.setContentLength((int)file.length());
			
			//다운 시 파일의 이름을 지정하고 인코딩 설정
			String downName = boardFileDTO.getOriName();
			downName = URLEncoder.encode(downName, "UTF-8");
			
			// 응답에서 header 정보 설정
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + downName + "\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			// 전송하기
			// 파일 연결선 꽃기 
			FileInputStream fi = new FileInputStream(file);
			// 어디로 보낼지 정하기
			OutputStream os = response.getOutputStream();
			
			// 파일 최종적으로 내보내기
			FileCopyUtils.copy(fi, os);
			
			//자원 해제
			os.close();
			fi.close();
	}
	
}
