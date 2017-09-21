package com.liying.service;

import java.util.List;

import com.liying.model.Student;

public interface StudentManager
{
	public boolean checkStudentId(String studentId);//验证学号是否存在
	public boolean logincheck(Student student);//学号密码登录验证
	public boolean addStudentInfo(Student student);//添加学生
	public List<Student>  gainStudentInfo(String clasId);//得到学生信息
	public Student forTheStudentInfo(String studentId);//得到要编辑学生的信息
	public boolean  updateStudentInfo(Student student);//更改学生信息
	public boolean  deleteStudentInfo(String studentId);//删除学生信息
	public List<Student> StudentsInfo();//返回所有学生信息
	public Student TheStudentInfo(String studentId);//返回某学生的信息
}
