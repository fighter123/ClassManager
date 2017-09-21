package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Course;
import com.liying.service.CourseManager;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Component("courseAction")
@Scope("prototype")	
public class CourseAtion extends ActionSupport
{
	//变量***********************************************************************
	private CourseManager courseManager;//注入
	private Course course;
	private String courseId;
	private String courseName;
	private String courseProperty;
	private String courseCredits;
	//返回变量
	private List<Course> courses = new ArrayList<Course>();	
	int state=0;
	//方法***********************************************************************
	//所有课程
	public String forAllCourse()
	{
		this.courses=courseManager.gainAllCourses();
		return "success";
	}
	//添加课程
	public String addCourse()
	{
		course = new Course();
		course.setCourseCredits(courseCredits);
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCourseProperty(courseProperty);
		System.out.println(courseId+courseName+courseProperty+courseCredits);
		if(courseManager.addCourse(course))
		{
			state=1;
		}
		else
		{
			state=0;
		}
		return "success";
	}
	//删除课程
	public String deleteCourse()
	{
		System.out.println(courseId);
		if(courseManager.deleteCourse(courseId))
		{
			state=1;
		}
		else {
			state=0;
		}
		return "success";
	}
	//得到要修改的课程信息
	public String gainTheCourse()
	{
		this.course=courseManager.gainTheCourse(courseId);
		return "success";
	}
	//修改课程
	public String updateCourse()
	{
		course = new Course();
		course.setCourseCredits(courseCredits);
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCourseProperty(courseProperty);
		System.out.println(courseId+courseName+courseProperty+courseCredits);
		if(courseManager.updateCourse(course))
		{
			state=1;
		}
		else
		{
			state=0;
		}
		return "success";
	}
	//set和get方法****************************************************************
	public String getCourseId()
	{
		return courseId;
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
	public String getCourseName()
	{
		return courseName;
	}
	public String getCourseProperty()
	{
		return courseProperty;
	}
	public String getCourseCredits()
	{
		return courseCredits;
	}
	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	public void setCourseProperty(String courseProperty)
	{
		this.courseProperty = courseProperty;
	}
	public void setCourseCredits(String courseCredits)
	{
		this.courseCredits = courseCredits;
	}
	public Course getCourse()
	{
		return course;
	}
	public void setCourse(Course course)
	{
		this.course = course;
	}
	public List<Course> getCourses()
	{
		return courses;
	}
	public int getState()
	{
		return state;
	}
	public void setCourses(List<Course> courses)
	{
		this.courses = courses;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	
}
