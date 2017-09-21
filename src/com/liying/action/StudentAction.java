package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Clas;
import com.liying.model.Student;
import com.liying.service.ClassManager;
import com.liying.service.StudentManager;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Component("studentAction")
@Scope("prototype")	
public class StudentAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//变量***********************************************************************
	private StudentManager studentManager;//注入变量
	private ClassManager classManager;//注入变量
	private Student student;
	private String studentId;
	private String passWord;
	private String clasId;
	private String studentName;
	private String sex;
	private String birthday;
	private String phone;
	private String adress;
	private String state;   //返回登录请求状态码
	private List<Student> students = new ArrayList<Student>();
	private List<Clas> cList = new ArrayList<Clas>();//用于返回所有的班级信息
	
	//方法***********************************************************************
	//学生登录
	public String studentLogin()
	{
		//为student赋值
		System.out.println("进入studentLogin方法");
		student = new Student();
		student.setStudentId(studentId);
		student.setPassword(passWord);
		System.out.println(student);
		
		if(studentManager.checkStudentId(studentId))
		{
				if(studentManager.logincheck(student))
				{
					state="1";
					System.out.println(state);
				}
				else {
					state="2";
					System.out.println(state);
				}
		}
		else
		{
			state="0";
		}
		return "success";
	}
	//添加学生信息
	public String addStudentInfo()
	{
		System.out.println(passWord+studentName+sex+birthday+phone+adress+clasId+studentId);
		student = new Student();
		student.setAdress(adress);
		student.setBirthday(birthday);
		student.setClas(classManager.getEditClasInfo(clasId));
		student.setPassword(passWord);
		student.setPhone(phone);
		student.setSex(sex);
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		if(studentManager.checkStudentId(studentId))
		{
			state="2";
		}
		else {
			if(studentManager.addStudentInfo(student))
			{
				state="1";
			}
			else {
				state="0";
			}
		}	
		return "success";
	}
	//返回学生信息
	public String forStudentInfo()
	{
		this.cList=classManager.getClassInfo();
		System.out.println(clasId);
		this.students=studentManager. gainStudentInfo(clasId);
		System.out.println(students);
		state="1";
		return "success";
	}
	//返回要编辑学生信息
	public String forTheStudentInfo()
	{
		this.cList=classManager.getClassInfo();
		this.student=studentManager.forTheStudentInfo(studentId);
		return "success";		
	}
	//更新学生信息
	public String updateStudentInfo()
	{
		student = new Student();
		student.setAdress(adress);
		student.setBirthday(birthday);
		student.setPassword(passWord);
		student.setPhone(phone);
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		if(studentManager.updateStudentInfo(student))
		{
			state="1";
		}
		else{
			state="0";
		}
		return "success";
	}
	//删除学生信息
	public String deleteStudentInfo()
	{
		if(studentManager.deleteStudentInfo(studentId))
		{
			state="1";
		}
		else
		{
			state="0";
		}
		return "success";
	}
	//setter注入*****************************************************************
	@Resource
	public void setClassManager(ClassManager classManager)
	{
		this.classManager = classManager;
	}
	@Resource
	public void setStudentManager(StudentManager studentManager)
	{
		this.studentManager = studentManager;
	}
	//set()和get()**************************************************************
	public String getPassWord()
	{
		return passWord;
	}
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}

	public String getStudentId()
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}
	public String getClasId()
	{
		return clasId;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public String getSex()
	{
		return sex;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getAdress()
	{
		return adress;
	}
	public void setClasId(String clasId)
	{
		this.clasId = clasId;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	public List<Student> getStudents()
	{
		return students;
	}
	public void setStudents(List<Student> students)
	{
		this.students = students;
	}
	public List<Clas> getCList()
	{
		return cList;
	}
	public void setCList(List<Clas> cList)
	{
		this.cList = cList;
	}
}
