package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAOImpl dao;
	
	public Map login(Map<String, Object> map) throws Exception {
		return dao.login(map);
	}
	
	public int join(Map<String, Object> map) throws Exception {
		return dao.join(map);
	}
	
	@Override
	public List<BoardDTO> list() {
		return dao.list();
	}

	@Override
	public BoardDTO getDetail(int bno) {
		return dao.getDetail(bno);
	}
	
	@Override
	public int updateReadCnt(int bno) {
		return dao.updateReadCnt(bno);
	}


	@Override
	public int register(BoardDTO boardDTO) {
		return dao.register(boardDTO);
	}

	@Override
	public int delete(int bno) {
		return dao.delete(bno);
	}
	
	public int update(BoardDTO boardDTO) {
		return dao.update(boardDTO);
	}

	@Override
	public int reply(BoardReply boardReply) {
		return dao.reply(boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		return dao.getDetail1(bno);
	}

	@Override
	public BoardReply detailreply(int reno) {
		// TODO Auto-generated method stub
		return dao.detailreply(reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return dao.replyupdate(boardReply);
	}
	
}
