package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.GradeDao;
import com.liying.model.CourseGrade;
import com.liying.model.Grade;
import com.liying.model.StudentGrade;
import com.liying.service.GradeManager;
@Component
public class GradeManagerImpl implements GradeManager
{
	private GradeDao gradeDao;
	
	public GradeDao getGradeDao()
	{
		return gradeDao;
	}
	@Resource
	public void setGradeDao(GradeDao gradeDao)
	{
		this.gradeDao = gradeDao;
	}
	@Override
	public boolean addGrade(Grade grade)
	{
		// TODO Auto-generated method stub
		return gradeDao.saveGrade(grade);
	}
	@Override
	public List<StudentGrade> returnTheStudentGrades(String studentId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheStudentGrades(studentId);
	}
	@Override
	public String returnZongXueFen(String studentId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnZongXueFen(studentId);
	}
	@Override
	public List<CourseGrade> returnTheCourseGrades(String courseId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheCourseGrades(courseId);
	}
	@Override
	public String returnTheCourseMaxGrade(String courseId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheCourseMaxGrade(courseId);
	}
	@Override
	public String returnTheCourseMinGrade(String courseId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheCourseMinGrade(courseId);
	}
	@Override
	public String returnTheCoursePingjunGrade(String courseId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheCoursePingjunGrade(courseId);
	}
	@Override
	public String returnTheCourseBujige(String courseId)
	{
		// TODO Auto-generated method stub
		return gradeDao.returnTheCourseBujige(courseId);
	}

}
