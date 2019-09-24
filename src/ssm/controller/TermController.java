package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Department;
import ssm.entity.Term;
import ssm.service.TermService;

@Controller
public class TermController {
	
	@Autowired
	private TermService termService;

	//1.访问学期管理界面，并展示
	@RequestMapping("/term_list")
	public ModelAndView term_list() {
		ModelAndView mView=new ModelAndView("term/term_list");
		List<Term> term=termService.getTerm();
		for (Term term2 : term) {
			System.out.println(term2);
		}
		mView.addObject("term",term);
		return mView;
	}
	

	//2.访问学期管理（添加）界面
		@RequestMapping("/term_add")
		public ModelAndView term_add() {
			ModelAndView mv=new ModelAndView("term/term_add");
//			List<Department> depname=courseService.getDepartment();
//			mv.addObject("depname",depname);
			return mv;
		}
	
	
}