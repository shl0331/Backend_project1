package com.koreait.app.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;

public class FileDownloadAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//sysname : 저장된 파일명
		String filename = request.getParameter("shareboardfilename");
		//orgname : 원래 파일명
		String shareboardrealname = request.getParameter("orgname");
		// 파일 경로
		String saveFolder = "C:\\file";
		
		 
		// 파일  경로/파일
		String shareboardfilename = saveFolder+"\\"+filename;
		System.out.println(shareboardfilename);
		
		// 다운로드를 위한 통로역할
		InputStream is = null;
		OutputStream os = null;
		
		// 다운받으려는 파일을 자바로 객체로 가져옴
		File file = new File(shareboardfilename);
		
		//file을 읽어오기 위한 통로
		is = new FileInputStream(file);
		
		// 현재 다운로드 받으려는 사용자의 로컬정보가  담긴 헤더
		String client = request.getHeader("User-Agent");
		// 응답하기  전에 비워줌
		response.reset();
		
		// 파일 다운로드 준비를 위한 세팅
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "JSP Generated Data");
		
		// 실제 다운로드 했을 때 파일의 이름을 담은 문자열
		String dwName = "";
		
		try {
			try {
				// db에 저장된 이름 -> 실제 파일 이름으로 바꿔주는 과정(둘이 같으면 오류 발생)
				dwName = URLEncoder.encode(shareboardrealname,"UTF-8").replaceAll("\\+", "%20");
			}catch(Exception e) {
				//db에 저장된 이름과 실제 파일 이름이 같으면 그냥 넣는다.(db에 저장된 파일이름)
				dwName = URLEncoder.encode(file.getName(),"UTF-8").replaceAll("\\+", "%20");
			}
			// dwname을 인코딩
			dwName = new String(dwName.getBytes("UTF-8"),"ISO-8859-1");
			
			//MSIE가 포함되지않으면(-1) (익스플러러)
			if(client.indexOf("MSIE") != -1) {
				//MSIE -> 익스플러러											
				response.setHeader("Content-Disposition", "attachment; fileName="+dwName); 
			}else {
				// 익스플러러가 아님												
				response.setHeader("Content-Disposition", "attachment; fileName=\""+dwName+"\""); 
				response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
			response.setHeader("Content-Length",file.length()+"");
			
			// 파일 전송을 위한 통로
			os = response.getOutputStream();
			
			
			byte[] b = new byte[(int)file.length()];
			int leng=0;
			
			while((leng = is.read(b,0,b.length))!=-1) {
				os.write(b,0,leng);
			}
		} catch (Exception e) {
			System.out.println("FileDownloadAction : "+e);
		} finally {
			if(is!=null) {
				is.close();
			}
			if(os!=null) {
				os.close();
			}
		}
		return null;
	
	}

}
