package com.itwillbs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	// http://localhost:8088/fileUpload
	@RequestMapping(value = "/fileUpload",method = RequestMethod.GET)
	public void fileUploadFormGET() throws Exception{
		logger.debug(" fileUploadFormGET() 실행 ");
		logger.debug(" fileUpload.jsp 뷰페이지 연결 ");		
	}
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String fileUploadPOST(MultipartHttpServletRequest multiRequest,
			                     Model model) throws Exception{
		logger.debug(" fileUploadPOST() - 파일 업로드 처리 ");
		
		// 파일업로시 전달된 모든정보를 저장
		// logger.debug(""+multiRequest);
		Map paramMap = new HashMap();
		
		// 파일 정보를 제외한 모든 파라메터의 이름을 가져오기 
		Enumeration enu = multiRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multiRequest.getParameter(name);
			//logger.debug("name : "+name+", value : "+value);
			paramMap.put(name, value);
		}
		logger.debug(" paramMap : "+paramMap);
		
		// 파일 정보를 저장
		List fileList = fileProcess(multiRequest);
		paramMap.put("fileList", fileList);
		
		logger.debug(" paramMap : "+paramMap);
		// => 추가동작 디비에 전달해서 저장
		
		model.addAttribute("paramMap", paramMap);
		
		return "fileResult";
	}// fileUploadPOST
	
	
	// 파일정보(이름)을 저장, 파일업로드 처리
	private List<String> fileProcess(MultipartHttpServletRequest multiRequest) throws Exception{
		
		// 파일의 이름을 저장
		List<String> fileList = new ArrayList<String>();
		
		// 폼태그에서 전달된 파일의 정보를 받아오기
		//  (input태그 file의 이름을 모두 가져오기)
		Iterator<String> fileNames = multiRequest.getFileNames();
		while(fileNames.hasNext()) {
			// 파라메터 이름을 저장
			String fileName =  fileNames.next();
			logger.debug(" fileName : "+fileName);
			
			// 전달된 파일이름에 해당하는 MultipartFile정보 저장
			MultipartFile mFile = multiRequest.getFile(fileName);
			String oFileName = mFile.getOriginalFilename();
			logger.debug(" oFileName : "+oFileName);
			// 업로드된 실제 파일의 이름을 저장
			fileList.add(oFileName);
			
			// 실제 폴더 생성
			File file = new File("D:\\springupload\\"+oFileName);
			// 파일업로드
			if(mFile.getSize() != 0) { //첨부파일이 있을때
				if(!file.exists()) { // 파일,디렉터리(폴더)가 존재하는지 체크
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}// exists
				mFile.transferTo(file);
			}// getSize
		}//while
		
		return fileList;
	}
	
	
	// 다운로드
	@RequestMapping(value = "/download",method = RequestMethod.GET)
	public void fileDownloadGET(@RequestParam("fileName") String fileName,
			                    HttpServletResponse response) throws Exception{
		logger.debug(" fileDownloadGET() 실행 ");
		logger.debug(" fileName : "+fileName);
		
		// response를 통하는 통로 생성
		OutputStream out = response.getOutputStream();
		
		// 다운로드할 파일의 정보
		String downFile = "D:\\springupload\\"+fileName;
		
		// 다운로드할 파일객체 생성
		File file = new File(downFile);
		// 한글파일의 경우 인코딩 처리
		fileName = URLEncoder.encode(fileName,"UTF-8");
		
		// 썸네일 처리 동작 ---------------------------------------
		int lastIdx = fileName.lastIndexOf(".");  // test[. 인덱스]jpg
		String tmpFileName = fileName.substring(0, lastIdx);  // test
		
		File thumbFile = new File("D:\\springupload\\thumb\\"+tmpFileName+".png");
		
		if(thumbFile.exists()) {
			thumbFile.getParentFile().mkdirs();
			Thumbnails.of(file).size(50, 50).outputFormat("png").toFile(thumbFile);
		}
		
		// 썸네일 처리 동작 ---------------------------------------
		
		
		// 다운로드 창의 형태로 다운로드 되도록 설정
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		
		int data = 0;
		while( (data = fis.read(buffer)) != -1) {
			out.write(buffer,0,data);
		}
		out.flush(); // 공백채워서 전달
		
		fis.close();
		out.close();
	}
	
	
	
	
}//controller
