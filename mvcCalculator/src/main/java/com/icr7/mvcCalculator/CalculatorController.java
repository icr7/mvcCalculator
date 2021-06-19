package com.icr7.mvcCalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
	
	@RequestMapping("/ShowMyLoginPage")
	public String ShowloginPage() {
		return "loginPage";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView ProessLoginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("t1");
		String pass = request.getParameter("password");
		 if(name.toLowerCase().equals("ishwar")&&pass.equals("icr7")) {
			
			mv.setViewName("validPage");
			mv.addObject("username", name);
			
		 }
		 else {
			 mv.setViewName("errorPage");
		     mv.addObject("error","invalid username or password"); 
		 }
		 return mv;
	}
	
	@RequestMapping("/ShowMyCalPage")
	public String ShowCalPage() {
	
		return "calPage";
	}
	
	
	
	@RequestMapping("/processCal")
	public ModelAndView ProcessCal(HttpServletRequest req) {
	
		ModelAndView mv =new ModelAndView();
		int result = 0;
		int n1=Integer.parseInt(req.getParameter("t1"));
		int n2=Integer.parseInt(req.getParameter("t2"));
		String symbol=req.getParameter("opt");
		
		if(symbol.equals("+")){ result=n1+n2;}
		else if(symbol.equals("-")){ result=n1-n2;}
		else if(symbol.equals("*")){ result=n1*n2;}
		else if(symbol.equals("/")){ result=n1/n2;}
		
		    
			 mv.addObject("num1",n1);
			 mv.addObject("num2",n2);
			 mv.addObject("opt",symbol);
			 mv.addObject("output",result);
		     mv.setViewName("resultPage");
			
	    return mv;
	}
}
	
