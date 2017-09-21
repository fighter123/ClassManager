package com.liying.dao;

import java.util.List;

import com.liying.model.Student;

public interface StudentDao
{
	public boolean checkUserExistsWithStudentId(String studentId);//用户是否存在验证
	public boolean checkStudentByIdPass(Student student);//学号密码登录验证
	public boolean saveStudent(Student student);//保存学生信息
	public List<Student> gainStudentInfo(String clasId);
	public Student forTheStudentInfo(String studentId);//得到要编辑学生的信息
	public boolean  updateStudentInfo(Student student);//更改学生信息
	public boolean  deleteStudentInfo(String studentId);//删除学生信息
	public List<Student> StudentsInfo();//返回所有学生信息
	public Student TheStudentInfo(String studentId);//返回某学生的信息
}
