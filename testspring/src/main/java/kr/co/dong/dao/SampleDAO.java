package kr.co.dong.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO {
	@Inject
	private SqlSession sqlSession;
	private final String nameSpace = "sampleMapper";
	
	public int sample1(String col1) {
		return sqlSession.insert(nameSpace + ".sample1", col1);
	}
	
	public int sample2(String col2) {
		return sqlSession.insert(nameSpace +".sample2", col2);
	}
	
	
}
