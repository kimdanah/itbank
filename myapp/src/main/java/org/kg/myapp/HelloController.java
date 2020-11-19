package org.kg.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService;
	
//	public HelloController(HelloService helloService) {
//		this.helloService = helloService;
//	}
//	
//	@Autowired
//	HelloLog helloLog;
	
	public void sayHello(String name) {
//		System.out.print("시작시간 : ");
//		helloLog.printTime();
		System.out.println(helloService.sayHello(name)); //
//		System.out.print("종료시간 : ");
//		helloLog.printTime();
	}
	
}
