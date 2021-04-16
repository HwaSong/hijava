/*
 * 
 */
package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Inject //@Autowired
	private SqlSession sqlSession;
	
	private static final String nameSpace = "empMapper";
	
	@Override
	public int empCount() throws Exception {
		// 전체수 구하기
		return sqlSession.selectOne(nameSpace + ".cnt"); //. 빼먹지 않기
	}

	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpVO selectEmp(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
