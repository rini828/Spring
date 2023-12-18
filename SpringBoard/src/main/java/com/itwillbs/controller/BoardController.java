package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bService;
	
	// 글쓰기 - GET
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist",method = RequestMethod.GET)
	public void registGET() throws Exception{
		logger.debug("/board/regist -> registGET() 호출 ");
		logger.debug("/board/regist.jsp 뷰페이지로 이동");
	}
	
	// 글쓰기 - POST
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String registPOST(BoardVO vo,RedirectAttributes rttr) throws Exception{
		logger.debug("폼submit -> registPOST() 호출 ");
		// 한글 인코딩(필터)
		// 전달정보 저장
		logger.debug(" vo : "+vo);
		
		// 서비스 - DB에 글쓰기(insert) 동작 호출
		bService.boardWrite(vo);		
		logger.debug(" 글작성 완료! "); 
		
		rttr.addFlashAttribute("result", "CREATEOK");
		
		logger.debug("/board/listAll 이동");
//		return "/board/listAll"; (x-데이터 중복 작성)
		return "redirect:/board/listAll";
	}
	
	// http://localhost:8088/board/listAll
	// 게시판 리스트 - GET
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	public String listALLGET(Model model,
			                 @ModelAttribute("result") String result,
			                 HttpSession session
			                 ) throws Exception{
		logger.debug(" /board/listAll -> listALLGET() ");
		
		session.setAttribute("viewcntCheck", true);		
		
		// 서비스 - 디비에 저장된 글을 가져오기
		List<BoardVO> boardList = bService.boardListAll();
		logger.debug(" @@@ "+boardList);
		
		// 데이터를 연결된 뷰페이지로 전달(Model)
		model.addAttribute("boardList", boardList);
		
		
		//model.addAttribute("boardList", bService.boardListAll());
		
		return "/board/listAll";
	}
	
	// http://localhost:8088/board/read?bno=1
	// 글 본문보기 - GET
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno,
			            Model model,
			            HttpSession session) throws Exception{
		logger.debug("/board/read -> readGET() ");
		// 전달정보 저장
		logger.debug(" bno : "+bno);

		if((boolean) session.getAttribute("viewcntCheck")) {
			// 서비스 - bno에 해당하는 글 조회수 1증가
			//         (페이지 호출당 1번씩 증가/read페이지 새로고침시 증가X)
			bService.incrementViewCnt(bno);
			
			session.setAttribute("viewcntCheck", false);			
		}
		
		// 서비스 - bno에 해당하는 특정 글정보만 조회
		BoardVO resultVO = bService.getBoard(bno);
		// 연결된 뷰페이지로 이동시 정보를 전달
		model.addAttribute("resultVO", resultVO);
		
		// model.addAttribute(resultVO); => "boardVO" 이름
		// /board/read.jsp 뷰페이지로 이동
	}
	
	
	// 게시판 글 수정 - GET
	// http://localhost:8088/board/modify?bno=1
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,Model model) throws Exception{
		logger.debug("/board/modify -> modifyGET()호출");
		logger.debug(" 수정할 글번호 : "+bno);
		
		// 기존의 글정보를 가져와서 화면에 출력
		BoardVO resultVO = bService.getBoard(bno);
		// 글정보를 Model 객체 저장
		model.addAttribute("resultVO", resultVO);
		// 뷰페이지로 이동
	}
	
	// 게시판 글 수정 - POST
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception {
		logger.debug(" /modify form -> modifyPOST()");
		// 전달된 정보 저장(수정할 정보)
		logger.debug(" 수정할 정보 "+vo);
		
		// 서비스 - 정보수정 동작
		int result = bService.boardModify(vo);
		// 처리 완료후 페이지 이동(리스트)
		// + 수정 완료! 리스트에서 출력
		rttr.addFlashAttribute("result", "modifyOK");
		
		
		return "redirect:/board/listAll";
	}
	
	// 글 삭제
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public String removePOST(@ModelAttribute("bno") int bno,
			                 RedirectAttributes rttr ) throws Exception{
		logger.debug("/read form -> removePOST()");
		
		// 서비스 - 글 삭제 동작
		bService.boardRemove(bno);
		// " 글 삭제 완료! " 메세지 출력
		rttr.addFlashAttribute("result", "removeOK");
		
		return "redirect:/board/listAll";
	}
	
	
	
	
	

}
