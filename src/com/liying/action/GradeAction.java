package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Course;
import com.liying.model.CourseGrade;
import com.liying.model.Grade;
import com.liying.model.GradeId;
import com.liying.model.Student;
import com.liying.model.StudentGrade;
import com.liying.service.CourseManager;
import com.liying.service.GradeManager;
import com.liying.service.StudentManager;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Component("gradeAction")
@Scope("prototype")	
public class GradeAction extends ActionSupport
{
	//变量***********************************************************************
	//接收
	private String courseId;
	private String studentId;
	private String grade;
	private Grade gradeEntity;
	private Course course;
	private Student student;
	private GradeId gradeId;
	private String studentName;
	//注入
	private CourseManager courseManager;
	private StudentManager studentManager;
	private GradeManager gradeManager;
	//返回
	private List<Student> students = new ArrayList<Student>();
	private List<Course> courses = new ArrayList<Course>();
	private List<Grade> grades = new ArrayList<Grade>();
	private List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
	private List<CourseGrade> courseGrades = new ArrayList<CourseGrade>();
	private int state=0;
	private String zongXueFen;//返回给学生的总学分
	private String zuigaofen;//返回课程的最高分
	private String zuidifen;//返回课程的最低分
	private String pingjunfen;//返回课程的平均分
	private String bujige;//返回课程的不及格人数
	
	//方法***********************************************************************
	public String CourseIdsAndStudentIds()
	{
		System.out.println("进入CourseIdsAndStudentIds（）");
		this.courses=courseManager.gainAllCourses();
		this.students=studentManager.StudentsInfo();
		return "success";
	}
	public String addGrade()
	{
		System.out.println("进入addGrade（）");
		gradeEntity=new Grade();
		gradeId = new GradeId();
		gradeId.setCourseId(courseId);
		gradeId.setStudentId(studentId);
		gradeEntity.setGrade(grade);
		gradeEntity.setId(gradeId);	
		if(gradeManager.addGrade(gradeEntity))
		{
			state=1;
		}
		else {
			state=0;
		}
		return "success";
	}
	public String returnTheStudentGrade()
	{
		this.students=studentManager.StudentsInfo();
		this.studentGrades=gradeManager.returnTheStudentGrades(studentId);
		this.student=studentManager.TheStudentInfo(studentId);
		this.zongXueFen=gradeManager.returnZongXueFen(studentId);
		return "success";
	}
	
	public String returnTheCourseGrade()
	{
		System.out.println(courseId);
		this.courses=courseManager.gainAllCourses();
		this.course=courseManager.gainTheCourse(courseId);
		this.courseGrades=gradeManager.returnTheCourseGrades(courseId);
		this.zuigaofen=gradeManager.returnTheCourseMaxGrade(courseId);
		this.zuidifen=gradeManager.returnTheCourseMinGrade(courseId);
		this.pingjunfen=gradeManager.returnTheCoursePingjunGrade(courseId);
		this.bujige=gradeManager.returnTheCourseBujige(courseId);
		return "success";
	}
	//set和get******************************************************************
	public List<Student> getStudents()
	{
		return students;
	}
	public List<Course> getCourses()
	{
		return courses;
	}
	public CourseManager getCourseManager()
	{
		return courseManager;
	}
	@Resource
	public void setCourseManager(CourseManager courseManager)
	{
		this.courseManager = courseManager;
	}
	public void setStudents(List<Student> students)
	{
		this.students = students;
	}
	public void setCourses(List<Course> courses)
	{
		this.courses = courses;
	}

	public StudentManager getStudentManager()
	{
		return studentManager;
	}
	@Resource
	public void setStudentManager(StudentManager studentManager)
	{
		this.studentManager = studentManager;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public String getCourseId()
	{
		return courseId;
	}
	public String getStudentId()
	{
		return studentId;
	}
	public String getGrade()
	{
		return grade;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	public Grade getGradeEntity()
	{
		return gradeEntity;
	}
	public void setGradeEntity(Grade gradeEntity)
	{
		this.gradeEntity = gradeEntity;
	}
	public GradeManager getGradeManager()
	{
		return gradeManager;
	}
	@Resource
	public void setGradeManager(GradeManager gradeManager)
	{
		this.gradeManager = gradeManager;
	}
	public List<Grade> getGrades()
	{
		return grades;
	}
	public void setGrades(List<Grade> grades)
	{
		this.grades = grades;
	}
	public List<StudentGrade> getStudentGrades()
	{
		return studentGrades;
	}
	public void setStudentGrades(List<StudentGrade> studentGrades)
	{
		this.studentGrades = studentGrades;
	}
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public String getZongXueFen()
	{
		return zongXueFen;
	}
	public void setZongXueFen(String zongXueFen)
	{
		this.zongXueFen = zongXueFen;
	}
	public Course getCourse()
	{
		return course;
	}
	public void setCourse(Course course)
	{
		this.course = course;
	}
	public List<CourseGrade> getCourseGrades()
	{
		return courseGrades;
	}
	public void setCourseGrades(List<CourseGrade> courseGrades)
	{
		this.courseGrades = courseGrades;
	}
	public String getZuigaofen()
	{
		return zuigaofen;
	}
	public String getZuidifen()
	{
		return zuidifen;
	}
	public String getPingjunfen()
	{
		return pingjunfen;
	}
	public String getBujige()
	{
		return bujige;
	}
	public void setZuigaofen(String zuigaofen)
	{
		this.zuigaofen = zuigaofen;
	}
	public void setZuidifen(String zuidifen)
	{
		this.zuidifen = zuidifen;
	}
	public void setPingjunfen(String pingjunfen)
	{
		this.pingjunfen = pingjunfen;
	}
	public void setBujige(String bujige)
	{
		this.bujige = bujige;
	}
	
	
}
