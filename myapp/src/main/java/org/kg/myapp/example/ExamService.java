package org.kg.myapp.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
	
	@Autowired
	ExamRepository examRepository;
	

	public String example() {
		return examRepository.example();
	}

}
