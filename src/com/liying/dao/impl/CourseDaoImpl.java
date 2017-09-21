package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.CourseDao;
import com.liying.model.Course;

@Component
public class CourseDaoImpl implements CourseDao
{
	private HibernateTemplate hibernateTemplate;
	//方法***********************************************************************
	@Override
	public boolean saveCourse(Course course)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(course);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean deleteCourse(String courseId)
	{
		// TODO Auto-generated method stub
		try
		{
			Course course = (Course)hibernateTemplate.get(Course.class, courseId);
			hibernateTemplate.delete(course);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.update(course.getCourseId(), course);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Course> gainAllCourses()
	{
		// TODO Auto-generated method stub
		List<Course> courses = hibernateTemplate.find("from Course");
		return courses;
	}
	
	@Override
	public Course gainTheCourse(String courseId)
	{
		// TODO Auto-generated method stub
		Course course = (Course)hibernateTemplate.get(Course.class, courseId);
		return course;
	}

	//注入***********************************************************************
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
}
