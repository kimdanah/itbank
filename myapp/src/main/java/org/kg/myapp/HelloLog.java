package org.kg.myapp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloLog {
//	public void printTime() {
//		System.out.println(new java.util.Date());
//	}
	
	@Pointcut(value = "execution(* org..HelloController.*(..))")
	private void helloPointcut() {
		
	}
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		System.out.println("클래스 : " + method.getDeclaringTypeName()+", 메서드 : " + method.getName());
		System.out.println("시작 시간 : " +new java.util.Date());
	}
	
	@After("helloPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		System.out.println("클래스 : " + method.getDeclaringTypeName()+", 메서드 : " + method.getName());
		System.out.println("종료 시간 : " +new java.util.Date());
	}

}
