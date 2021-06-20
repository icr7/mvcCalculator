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
	DecimalChecker myNumber = new DecimalChecker();
	int n1, n2, radio, result1;
	String status1, status2, symbol;
	double d1, d2, result2;
	boolean quotientIsDouble;

	@RequestMapping("/ShowMyLoginPage")
	public String ShowloginPage() {
		return "loginPage";
	}

	@RequestMapping("/login")
	public ModelAndView ProessLoginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		if (name.toLowerCase().equals("ishwar") && pass.equals("icr7")) {

			mv.setViewName("validPage");
			mv.addObject("username", name);

		} else {
			mv.setViewName("errorPage");
			mv.addObject("error", "invalid username or password");
		}
		return mv;
	}

	@RequestMapping("/ShowMyCalPage")
	public String ShowCalPage() {

		return "calPage";
	}

	@RequestMapping("/processCal")
	public ModelAndView ProcessCal(@RequestParam("t1") String s1, @RequestParam("t2") String s2,
			@RequestParam("opt") String symbol) {

		ModelAndView mv = new ModelAndView();

		if (!s1.equals("")) {
			Boolean check = myNumber.isInteger(s1);
			if (check) {
				n1 = (int) (Double.parseDouble(s1)); // (int)parseDouble(s1) used to satisfy test case for 3.0 like
														// input where
														// o/p will be true but still treated as double and cause
														// nameFormatEception
				status1 = "integer";
			} else {
				d1 = (Double.parseDouble(s1));
				status1 = "double";
			}
		}

		if (!s2.equals("")) {
			Boolean check = myNumber.isInteger(s2);
			if (check) {

				n2 = (int) (Double.parseDouble(s2));
				status2 = "integer";
			} else {
				d2 = (Double.parseDouble(s2));
				status2 = "double";

			}

		}

		// int,int
		if (status1.equals("integer") && status2.equals("integer")) {
			if (symbol.equals("+")) {
				result1 = n1 + n2;
				radio = 0;
			} else if (symbol.equals("-")) {
				result1 = n1 - n2;
				radio = 1;
			} else if (symbol.equals("*")) {
				result1 = n1 * n2;
				radio = 2;
			} else if (symbol.equals("/")) {
				if (n1 % n2 == 0) {
					quotientIsDouble = false;
					result1 = n1 / n2;
				} else {
					quotientIsDouble = true;
					// for providing accurate decimal result in case both input are int
				}

				radio = 3;
			}

			mv.addObject("num1", n1);
			mv.addObject("num2", n2);
			mv.addObject("opt", symbol);
			mv.addObject("symbolNum", radio);
			if (symbol.equals("/") && quotientIsDouble)// for providing accurate decimal result in case both input are
														// int
			{
				mv.addObject("output", (double) n1 / (double) n2);
			} else
				mv.addObject("output", result1);
			mv.setViewName("resultPage");

		}
		// int,double
		else if (status1.equals("integer") && status2.equals("double")) {
			if (symbol.equals("+")) {
				result2 = (int) n1 + d2;
				radio = 0;
			} else if (symbol.equals("-")) {
				result2 = (int) n1 - d2;
				radio = 1;
			} else if (symbol.equals("*")) {
				result2 = (int) n1 * d2;
				radio = 2;
			} else if (symbol.equals("/")) {
				result2 = (int) n1 / d2;
				radio = 3;
			}

			mv.addObject("num1", n1);
			mv.addObject("num2", d2);
			mv.addObject("opt", symbol);
			mv.addObject("symbolNum", radio);
			mv.addObject("output", result2);
			mv.setViewName("resultPage");

		}
		// double,int
		else if (status1.equals("double") && status2.equals("integer")) {
			if (symbol.equals("+")) {
				result2 = d1 + (double) n2;
				radio = 0;
			} else if (symbol.equals("-")) {
				result2 = d1 - (double) n2;
				radio = 1;
			} else if (symbol.equals("*")) {
				result2 = d1 * (double) n2;
				radio = 2;
			} else if (symbol.equals("/")) {
				result2 = d1 / (double) n2;
				radio = 3;
			}

			mv.addObject("num1", d1);
			mv.addObject("num2", n2);
			mv.addObject("opt", symbol);
			mv.addObject("symbolNum", radio);
			mv.addObject("output", result2);
			mv.setViewName("resultPage");

		}
		// double,double
		else if (status1.equals("double") && status2.equals("double")) {
			if (symbol.equals("+")) {
				result2 = d1 + d2;
				radio = 0;
			} else if (symbol.equals("-")) {
				result2 = d1 - d2;
				radio = 1;
			} else if (symbol.equals("*")) {
				result2 = d1 * d2;
				radio = 2;
			} else if (symbol.equals("/")) {
				result2 = d1 / d2;
				radio = 3;
			}

			mv.addObject("num1", d1);
			mv.addObject("num2", d2);
			mv.addObject("opt", symbol);
			mv.addObject("symbolNum", radio);
			mv.addObject("output", result2);
			mv.setViewName("resultPage");

		}

		return mv;
	}
}
