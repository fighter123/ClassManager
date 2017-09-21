package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.From;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.StudentDao;
import com.liying.model.Student;
@Component
public class StudentDaoImpl implements StudentDao
{

	private HibernateTemplate hibernateTemplate;
	@Override
	public boolean checkStudentByIdPass(Student student)
	{
		System.out.println("进入dao");
		System.out.println(student.getPassword()+";"+student.getStudentId());
		// TODO Auto-generated method stub
		List<Student> students=  hibernateTemplate.find("from Student s where s.studentId='"+student.getStudentId()+"' and s.password='"+student.getPassword()+"'");
		if(students!=null&&students.size()>0)
		{
			return true;
		}
		return false;
	}
	public boolean checkUserExistsWithStudentId(String studentId) {
		//System.out.println("这里是dao层！");
		try
		{
			List<Student> students=  hibernateTemplate.find("from Student s where s.studentId='"+studentId+"'");
			if(students!=null&&students.size()>0)
			{
				return true;
			}
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			System.out.println("可能是数据库服务没开；"+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean saveStudent(Student student)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(student);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public List<Student> gainStudentInfo(String clasId)
	{
		// TODO Auto-generated method stub
		List<Student> students = hibernateTemplate.find("from Student u where u.clas.clasId='"+clasId+"'");
		return students;
	}
	public Student forTheStudentInfo(String studentId)
	{
		Student student=(Student)hibernateTemplate.get(Student.class,studentId);
		return student;
	}
	
	//set和get******************************************************************
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public boolean updateStudentInfo(Student student)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.update(student.getStudentId(),student);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteStudentInfo(String studentId)
	{
		// TODO Auto-generated method stub
		try
		{
			Student student = (Student)hibernateTemplate.get(Student.class, studentId);
			hibernateTemplate.delete(student);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public List<Student> StudentsInfo()
	{
		// TODO Auto-generated method stub
		System.out.println("进入dao");
		List<Student> students = hibernateTemplate.find("from Student");
		return students;
	}
	@Override
	public Student TheStudentInfo(String studentId)
	{
		// TODO Auto-generated method stub
		Student student=(Student)hibernateTemplate.get(Student.class,studentId);
		return student;
	}
}
