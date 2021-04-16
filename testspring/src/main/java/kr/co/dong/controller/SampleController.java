package kr.co.dong.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import kr.co.dong.service.SampleService;

@Controller
public class SampleController {
	@Inject
	private SampleService sampleService;
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	

}
