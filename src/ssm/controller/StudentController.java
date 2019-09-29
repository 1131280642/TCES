package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.ResultMsg;
import ssm.entity.Student;
import ssm.service.ClassService;
import ssm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	
	@RequestMapping("/student_list")
	public ModelAndView list() {
		List<Student> students=studentService.selectStudent();
		ModelAndView mView = new ModelAndView("student/list");
		mView.addObject("students",students);
		return mView;
	}
	
	@RequestMapping("/student_add")
	public ModelAndView add() {
		List<Classes> classes=classService.getClasses();
		ModelAndView mView = new ModelAndView("student/add");
		mView.addObject("classes",classes);
		return mView;
	}
	
	@RequestMapping("/add_student")
	@ResponseBody
	public ResultMsg add_student(Student student) {
		int idResult=studentService.selectStudentById(student.getStudent_no());
		if(idResult==1) {
			return new ResultMsg(-1, "��ѧ���ѱ�����!");
		}else {
			int addResult=studentService.addStudent(student);
			if(addResult>0) {
				return new ResultMsg(1, "���ѧ���ɹ�!");
			}else {
				return new ResultMsg(0, "���ѧ��ʧ��!");
			}
		}
	}
	@RequestMapping("/student_update")
	public ModelAndView student_update(int id) {
		List<Classes> classes=classService.getClasses();
		Student student=studentService.selectStudentById1(id);
		ModelAndView mView = new ModelAndView("student/update");
		mView.addObject("student",student);
		mView.addObject("classes",classes);
		return mView;
	}
	
	@RequestMapping("/update_student")
	@ResponseBody
	public ResultMsg update_student(Student student) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
		
			int updateResult=studentService.updateStudent(student);
			if(updateResult>0) {
				return new ResultMsg(1, "�޸���Ϣ�ɹ�!");
			}else {
				return new ResultMsg(0, "�޸���Ϣʧ��!");
			}
		}
	
	@RequestMapping("/delete_student")
	@ResponseBody
	public ResultMsg delete_student(int id) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
		
			int deleteResult=studentService.deletestudent(id);
			if(deleteResult>0) {
				return new ResultMsg(1, "ɾ��ѧ���ɹ�!");
			}else {
				return new ResultMsg(0, "ɾ��ѧ��ʧ��!");
			}
		}
	
	//ѧ���޸�����
			@RequestMapping("/updatestudent_pwd")
			public ModelAndView updatepwd() {
				ModelAndView mv=new ModelAndView("information/updatestudent_pwd");
//				List<Teacher> teachers=teacherInformationService.getTeacher();
//				mv.addObject("teachers",teachers);
				return mv;
			}
			
			@RequestMapping("/studentpwd_update")
			@ResponseBody
			public ResultMsg pwd_update(String student_no,String oldpwd,String newpwd2) {
				
				Student student=new Student();
				student.setStudent_no(student_no);
				student.setStudent_pwd(newpwd2);
				String  oldpwdResult=studentService.selectStudentpwdByNo(student_no);
				//System.out.println(oldpwd);
				if (oldpwd.equals(oldpwdResult)) {
					int i=studentService.updateStudentpwd(student);
					if (i>0) {
						return new ResultMsg(1, "�޸�����ɹ�");
					}else {
						return new ResultMsg(0, "�޸�����ʧ��");
					}
					
				}else {
					return new ResultMsg(-1, "ԭ���벻��");
				}
		}
	}

