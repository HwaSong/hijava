package kr.co.dong.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.dao.SampleDAO;

@Service
public class SampleService {
	@Inject
	private SampleDAO sampleDAO;
	
	public int sample1(String col1) {
		return sampleDAO.sample1(col1);
	}
	
	public int sample2(String col2) {
		return sampleDAO.sample2(col2);
	}
}
