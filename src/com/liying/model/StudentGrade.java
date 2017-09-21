package com.liying.model;

public class StudentGrade//用于返回学生成绩信息的实体类
{
	private String grade;
	private String courseId;
	private String courseName;
	private String courseProperty;
	private String courseCredits;
	
	public StudentGrade( String grade, String courseId,
			String courseName, String courseProperty, String courseCredits)
	{
		super();
		this.grade = grade;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseProperty = courseProperty;
		this.courseCredits = courseCredits;
	}
	
	public String getGrade()
	{
		return grade;
	}
	public String getCourseId()
	{
		return courseId;
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
	public void setGrade(String grade)
	{
		this.grade = grade;
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
}
