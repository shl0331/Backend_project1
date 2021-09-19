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
		//sysname : �쁽�옱 �꽌踰꾩뿉 ���옣�릺�뼱 �엳�뒗 �뙆�씪�쓽 �씠由�
		String filename = request.getParameter("shareboardfilename");//day011.txt
		//orgname : 洹� �뙆�씪�쓣 �삱由� �븣�쓽 �씠由�
		String shareboardrealname = request.getParameter("orgname");//day01.txt
		//�떎�젣濡� �뙆�씪�씠 ���옣�릺�뼱 �엳�뒗 �뤃�뜑 �쐞移�
		String saveFolder = "C:\\file";
		
		//�떎�젣�뤃�뜑�쐞移섏� ���옣�릺�뼱�엳�뒗 �뙆�씪 �씠由꾩쓣 �뿰寃고빐�꽌 �뙆�씪�쓽 寃쎈줈 �셿�꽦
		//				D:\.....\file	\	day011.txt
		String shareboardfilename = saveFolder+"\\"+filename;
		System.out.println(shareboardfilename);
		
		//�떎�슫濡쒕뱶瑜� �쐞�븳 �넻濡쒖뿭�븷
		InputStream is = null;//�뙆�씪�쓣 履쇨컻�꽌 �씫�뼱�삱 �넻濡�
		OutputStream os = null;//履쇨컻吏� �뙆�씪�쓣 �뜥以� �넻濡�
		
		//�떎�슫諛쏆쑝�젮�뒗 �뙆�씪�쓣 �옄諛붾줈 媛앹껜濡� 媛��졇�샂
		File file = new File(shareboardfilename);
		
		//file媛앹껜瑜� �씫�뼱�삤湲� �쐞�븳 �넻濡� 媛쒖꽕
		is = new FileInputStream(file);
		
		//�쁽�옱 �떎�슫濡쒕뱶瑜� �썝�븯�뒗 �궗�슜�옄�쓽 濡쒖뺄�젙蹂닿� �떞湲� �뿤�뜑
		String client = request.getHeader("User-Agent");
		response.reset();
		
		//�뙆�씪 �떎�슫濡쒕뱶 以�鍮꾨�� �쐞�븳 �꽭�똿
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "JSP Generated Data");
		
		//�슦由ш� �떎�젣濡� �떎�슫濡쒕뱶 �뻽�쓣 �븣 �떎�슫濡쒕뱶 �맆 �뙆�씪�쓽 �씠由꾩쓣 �떞�쓣 臾몄옄�뿴 蹂��닔
		String dwName = "";
		
		try {
			try {
				//orgname�쑝濡� 諛붽씀�뼱二쇰뒗 怨쇱젙 - 留뚯빟 orgname怨� systemname�씠 �룞�씪�븯�떎硫� �삤瑜섎컻�깮
				dwName = URLEncoder.encode(shareboardrealname,"UTF-8").replaceAll("\\+", "%20");
			}catch(Exception e) {
				//file媛앹껜�쓽 �씠由꾩쑝濡� dwName�쓣 �꽕�젙
				dwName = URLEncoder.encode(file.getName(),"UTF-8").replaceAll("\\+", "%20");
			}
			//dwName�쓣 �씤肄붾뵫
			dwName = new String(dwName.getBytes("UTF-8"),"ISO-8859-1");
			
			//�쑀���쓽 濡쒖뺄�젙蹂닿� �떞湲� �뿤�뜑�뿉 MSIE媛� �룷�븿�릺�뼱 �엳�뒗吏�瑜� 鍮꾧탳(�룷�븿�릺�뼱 �엳�쑝硫� -1�씠 �븘�땲怨� �뾾�쑝硫� -1)
			if(client.indexOf("MSIE") != -1) {
				//MSIE �씤 寃쎌슦												fileName=day01.txt
				response.setHeader("Content-Disposition", "attachment; fileName="+dwName); 
			}else {
				//洹� �쇅													fileName="day01.txt"
				response.setHeader("Content-Disposition", "attachment; fileName=\""+dwName+"\""); 
				response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
			response.setHeader("Content-Length",file.length()+"");
			
			//�궗�슜�옄媛� �떎�슫濡쒕뱶瑜� �슂泥��뻽�쓣 �븣 �떎�젣 �뙆�씪�쓣 �쟾�넚�빐二쇨린 �쐞�븳 �넻濡�
			os = response.getOutputStream();
			
			//�뙆�씪�쓣 諛붿씠�듃�떒�쐞濡� 履쇨컻�꽌 �떞�븘以� 諛곗뿴
			byte[] b = new byte[(int)file.length()];
			int leng=0;
			//�뙆�씪�쓽 �걹�씠 �삤湲� �쟾源뚯� 怨꾩냽 諛섎났
			while((leng = is.read(b,0,b.length))!=-1) {
				//os �넻濡쒕�� �넻�빐 �궗�슜�옄�쓽 而댄벂�꽣�뿉 �뙆�씪 �궡�슜 �뜥二쇨린
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
