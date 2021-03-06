package com.liying.dao;

import java.util.List;

import com.liying.model.Course;

public interface CourseDao
{
	public boolean saveCourse(Course course);//添加课程
	public boolean deleteCourse(String courseId);//添加课程
	public boolean updateCourse(Course course);//修改课程信息
	public List<Course> gainAllCourses();//返回所有课程信息
	public Course gainTheCourse(String courseId);//返回要修改的课程信息
}
