package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.EvaluateDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.EvaluateDao;
import ssm.entity.St_score;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.entity.Tt_score;

@Service
public class EvaluateService {

	@Autowired
	private EvaluateDao evaluateDao;
	
	//1.通过学生班级号，查询相应班级的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByNo(String classes_no){
		return evaluateDao.selectCourseTeacherByNo(classes_no);
	}
	
	//2.通过教师所在的部门id，查询相应部门的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByDepid(int dep_id){
		return evaluateDao.selectCourseTeacherByDepid(dep_id);
	}
	
	public int InsertSt_score(int score) {
		
		return evaluateDao.InsertSt_score(score);
	}
	
	public int InsertTt_score(int score) {
		
		return evaluateDao.InsertTt_score(score);
	}
	
	public Teacher_course selectCourseTeacherAllById(int id) {
		return evaluateDao.selectCourseTeacherAllById(id);
	}
	//5.通过学生评教列表id，查询信息
	public Teacher_course selectCourseTeacherByid(int id) {
		return evaluateDao.selectCourseTeacherByid(id);
	}
	
	public int insertSt_scoreInfo(St_score score) {
		return evaluateDao.insertSt_scoreInfo(score);
	}
	
	public int insertTt_scoreInfo(Tt_score score) {
		return evaluateDao.insertTt_scoreInfo(score);
	}
	
	//新
	public List<Teacher_course> selectCourseTeacherByDepid(Teacher teacher) {
		return evaluateDao.selectCourseTeacherByDepid(teacher);
	}
}
