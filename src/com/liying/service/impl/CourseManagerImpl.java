package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.CourseDao;
import com.liying.model.Course;
import com.liying.service.CourseManager;
@Component
public class CourseManagerImpl implements CourseManager
{

	private CourseDao courseDao;
	//方法***********************************************************************
	@Override
	public boolean addCourse(Course course)
	{
		// TODO Auto-generated method stub
		return courseDao.saveCourse(course);
	}
	
	@Override
	public boolean deleteCourse(String courseId)
	{
		// TODO Auto-generated method stub
		return courseDao.deleteCourse(courseId);
	}

	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		return courseDao.updateCourse(course);
	}
	
	@Override
	public List<Course> gainAllCourses()
	{
		// TODO Auto-generated method stub
		return courseDao.gainAllCourses();
	}
	@Override
	public Course gainTheCourse(String courseId)
	{
		// TODO Auto-generated method stub
		return courseDao.gainTheCourse(courseId);
	}
	
	//注入***********************************************************************
	public CourseDao getCourseDao()
	{
		return courseDao;
	}
	@Resource
	public void setCourseDao(CourseDao courseDao)
	{
		this.courseDao = courseDao;
	}


}
