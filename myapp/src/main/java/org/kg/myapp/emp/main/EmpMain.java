package org.kg.myapp.emp.main;

<<<<<<< HEAD
import org.kg.myapp.emp.model.dao.IEmpService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
		IEmpService empService = con.getBean( "empService" ,IEmpService.class);
		System.out.println("사원의 수 : "+ empService.getEmpCount());
		System.out.println("부서 인원 : " + empService.getEmpCount(30));
		System.out.println("사원 목록 ");
		System.out.println(empService.getEmpList());

	}

}
=======
import org.kg.myapp.emp.model.dao.EmpService;
import org.kg.myapp.emp.model.dao.IEmpService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
		IEmpService empService = con.getBean( "empService" ,IEmpService.class);
		System.out.println("사원의 수 : "+ empService.getEmpCount());
		System.out.println("부서 인원 : " + empService.getEmpCount(30));
		System.out.println("사원 목록 : " + empService.getEmpList());
		System.out.println("관리자Id : " + empService.getAllManagerId());
		con.close();
	}

}








>>>>>>> refs/remotes/origin/master
