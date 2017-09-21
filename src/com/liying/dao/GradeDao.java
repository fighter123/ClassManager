package com.liying.dao;

import java.util.List;

import com.liying.model.CourseGrade;
import com.liying.model.Grade;
import com.liying.model.StudentGrade;

public interface GradeDao
{
	public boolean saveGrade(Grade grade);//录入成绩
	public List<StudentGrade> returnTheStudentGrades(String studentId);//返回某学生的所有成绩
	public String returnZongXueFen(String studentId);//返回某学生的总学分
	public List<CourseGrade> returnTheCourseGrades(String courseId);//返回某课程的所有成绩
  	public String returnTheCourseMaxGrade(String courseId);//返回某课程的最高分
  	public String returnTheCourseMinGrade(String courseId);//返回某课程的最低分
  	public String returnTheCoursePingjunGrade(String courseId);//返回某课程的平均分
  	public String returnTheCourseBujige(String courseId);//返回某课程的不及格人数
}
