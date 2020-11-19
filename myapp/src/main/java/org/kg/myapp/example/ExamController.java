package org.kg.myapp.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	public void runExample() {
		System.out.println(examService.example());
	}
	
}
