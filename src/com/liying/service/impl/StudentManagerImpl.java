package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.StudentDao;
import com.liying.model.Student;
import com.liying.service.StudentManager;
@Component
public class StudentManagerImpl implements StudentManager
{
	private StudentDao studentDao;
	@Override
	public boolean checkStudentId(String studentId)
	{
		// TODO Auto-generated method stub
		return studentDao.checkUserExistsWithStudentId(studentId);
	}

	@Override
	public boolean logincheck(Student student)
	{
		// TODO Auto-generated method stub
		return studentDao.checkStudentByIdPass(student);
	}

	@Override
	public boolean addStudentInfo(Student student)
	{
		// TODO Auto-generated method stub
		return studentDao.saveStudent(student);
	}

	@Override
	public List<Student> gainStudentInfo(String clasId)
	{
		// TODO Auto-generated method stub
		return studentDao.gainStudentInfo(clasId);
	}

	@Override
	public Student forTheStudentInfo(String studentId)
	{
		// TODO Auto-generated method stub
		return studentDao.forTheStudentInfo(studentId);
	}

	@Override
	public boolean updateStudentInfo(Student student)
	{
		// TODO Auto-generated method stub
		return studentDao.updateStudentInfo(student);
	}

	@Override
	public boolean deleteStudentInfo(String studentId)
	{
		// TODO Auto-generated method stub
		return studentDao.deleteStudentInfo(studentId);
	}

	@Override
	public List<Student> StudentsInfo()
	{
		System.out.println("进入service");
		// TODO Auto-generated method stub
		return studentDao.StudentsInfo();
	}
	//注入
	public StudentDao getStudentDao()
	{
		return studentDao;
	}
	@Resource
	public void setStudentDao(StudentDao studentDao)
	{
		this.studentDao = studentDao;
	}

	@Override
	public Student TheStudentInfo(String studentId)
	{
		// TODO Auto-generated method stub
		return studentDao.TheStudentInfo(studentId);
	}

}
