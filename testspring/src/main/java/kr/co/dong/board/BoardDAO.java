package kr.co.dong.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	public Map login(Map<String, Object> map) throws Exception;
	//삽입, 삭제, 갱신(수정) 메소드의 리턴타입은 되도록이면 int
	
	//전체목록 가져오는 메소드
	public List<BoardDTO> list();
	
	//상세보기 처리를 위한 메소드(글읽기)
	public int updateReadCnt(int bno); //조회수 증가
	public BoardDTO getDetail(int bno); //getRead(), getView() 아무거나 괜찮음
//	public int getRead(int bno); //조회수 증가 및 읽기를 처리하는 메소드
	
	//글추가
	public int register(BoardDTO boardDTO);
	
	//글삭제
	public int delete(int bno);
	
	//글수정
	public int update(BoardDTO boardDTO);
	
	//댓글쓰기를 위한 메소드
	public int reply(BoardReply boardReply);
	
	//게시물 번호에 해당하는 댓글 조회
	public List<BoardReply> getDetail1(int bno);
	
	//댓글 수정보기를 위한 메소드
	public BoardReply detailreply(int reno);
	
	//댓글 수정을 처리하기 위한 메소드
	public int replyupdate(BoardReply boardReply);
	
}
