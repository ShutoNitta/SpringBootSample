package com.example.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ErrorAspect {

	@AfterThrowing(value = "execution(* *..*..*(..)) &&" + 
			"(bean(*Controller))",
			throwing = "ex")
	public void throwingNull(DataAccessException ex) {
		log.error("DataAccessExceptionが発生しました(Controller)");
	}
	@AfterThrowing(value = "execution(* *..*..*(..)) &&" + 
			"(bean(*Service))",
			throwing = "ex")
	public void throwingNull2(DataAccessException ex) {
		log.error("DataAccessExceptionが発生しました(Service)");
	}
	@AfterThrowing(value = "execution(* *..*..*(..)) &&" + 
			"(bean(*Repository))",
			throwing = "ex")
	public void throwingNull3(DataAccessException ex) {
		log.error("DataAccessExceptionが発生しました(Repository)");
	}
}
