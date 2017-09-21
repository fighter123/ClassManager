package com.liying.model;

public class CourseGrade//用于返回课程成绩信息的实体类
{
	private String studentId;
	private String studentName;
	private String grade;
	
	
	public CourseGrade(String studentId, String studentName, String grade)
	{
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.grade = grade;
	}
	
	public String getStudentId()
	{
		return studentId;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	
}
