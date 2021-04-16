package kr.co.dong.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.tools.doclint.HtmlTag.Attr;

import kr.co.dong.HomeController;
import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardReply;
import kr.co.dong.board.BoardServiceImpl;
import kr.co.song.domain.BoardVO;

@Controller
public class BoardController {
	@Inject
	private BoardServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="board/login", method=RequestMethod.GET)
	public String login() {
		logger.info("로그인 폼 처리화면입니다.");
		return "login";
	}
	
	@RequestMapping(value="board/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map , HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Map user = service.login(map);
		
		if(user == null) { //로그인 실패
			logger.info("로그인 안됨");
			return "redirect:login";
		}else {  // 로그인 성공
			//세션부여
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "board/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		rttr.addFlashAttribute("msg", "로그아웃되었습니다.");
		return "redirect:/";
	}
	
	@RequestMapping(value="board/join", method=RequestMethod.GET)
	public String join() {
		logger.info("회원가입 처리화면입니다.");
		return "join";
	}
	
	@RequestMapping(value="board/join", method=RequestMethod.POST)
	public String join(@RequestParam Map<String,Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int user = service.join(map);
		return "redirect:/";
	}
	
	@RequestMapping(value="board/list", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		List<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="board/register", method=RequestMethod.GET)
	public String register(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("글쓰기 처리화면입니다.");
		return "register";
	}
	
	@RequestMapping(value="board/register", method=RequestMethod.POST)
	public String register(@ModelAttribute BoardDTO boardDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int id = service.register(boardDTO);
		return "redirect:/";
	}
	
	@RequestMapping(value="board/detail", method=RequestMethod.GET)
	public String getDetail(Model model, @RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		request.setCharacterEncoding("utf-8");
		BoardDTO board = service.getDetail(bno);
		model.addAttribute("board", board);
		int readcnt = service.updateReadCnt(bno);
		
		//댓글 목록 조회
		List<BoardReply> replylist = service.getDetail1(bno);
		model.addAttribute("list", replylist);
		return "detail";
	}

	@RequestMapping(value="board/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = service.delete(bno);
		
		if(r>0) {
			return "redirect:list";
		}
		return "redirect:detail?bno=" + bno;
	}
	
	@RequestMapping(value="board/update", method=RequestMethod.GET)
	public String update(Model model, @RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		BoardDTO board = service.getDetail(bno);
		model.addAttribute("board", board);
		return "update";
	}
	
	@RequestMapping(value="board/update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO boardDTO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		request.setCharacterEncoding("utf-8");
		int id = service.update(boardDTO);
		if(id>0) {
			rttr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
			return "redirect:list";
		}
		return "redirect:update?bno=" + boardDTO.getBno();
	}
	
	@RequestMapping(value="board/reply", method=RequestMethod.GET)
	public String reply() {
		return "reply";
	}
	
	@RequestMapping(value="board/reply", method=RequestMethod.POST)
	public String reply(BoardReply boardReply) {
		int r = service.reply(boardReply);
		if(r>0) {
			return "redirect:detail?bno=" + boardReply.getBno();
		}
		return "reply";
	}
	
	@RequestMapping(value="board/replyupdate", method=RequestMethod.GET)
	public String replyUpdate(@RequestParam("reno")int reno, Model model) {
		BoardReply boardReply = service.detailreply(reno);
		model.addAttribute("boardReply",boardReply);
		return "replyupdate";
	}
	
	@RequestMapping(value="board/replyupdate", method=RequestMethod.POST)
	public String replyUpdate(BoardReply boardReply) {
		int r = service.replyupdate(boardReply);
		if(r > 0) {
			return "redirect:detail?bno=" + boardReply.getBno();
		}
		return "redirect:list";
	}
	
	
	
	
	
}
