package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace = "boardMapper";
	
	public Map login(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(nameSpace + ".login" , map);
	}
	
	public int join(Map<String, Object> map) throws Exception {
		int id = -1;
		id = sqlSession.insert(nameSpace + ".join" , map);
		return id;
	}

	@Override
	public List<BoardDTO> list() {
		return sqlSession.selectList(nameSpace + ".list");
	}

	@Override
	public BoardDTO getDetail(int bno) {
		return sqlSession.selectOne(nameSpace + ".getDetail", bno);
	}

	@Override
	public int updateReadCnt(int bno) {
		int readcnt = 0;
		readcnt = sqlSession.update(nameSpace + ".updateReadCnt", bno);
		return readcnt;
	}
	
	@Override
	public int register(BoardDTO boardDTO) {
		int id = -1;
		id = sqlSession.insert(nameSpace + ".register", boardDTO);
		return id;
	}

	@Override
	public int delete(int bno) {
		int id = -1;
		id = sqlSession.update(nameSpace + ".delete", bno);
		return id;
	}

	@Override
	public int update(BoardDTO boardDTO) {
		int id = -1;
		id = sqlSession.update(nameSpace + ".update", boardDTO);
		return id;
	}

	@Override
	public int reply(BoardReply boardReply) {
		return sqlSession.insert(nameSpace + ".reply", boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		return sqlSession.selectList(nameSpace + ".detail1", bno);
	}

	@Override
	public BoardReply detailreply(int reno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".detailReply", reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".replyupdate", boardReply);
	}


	
	
	
	
}
