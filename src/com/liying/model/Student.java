package com.liying.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "db_banjiguanli")
public class Student implements java.io.Serializable
{

	// Fields

	private String studentId;
	private Clas clas;
	private String studentName;
	private String sex;
	private String birthday;
	private String password;
	private String phone;
	private String adress;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String studentId)
	{
		this.studentId = studentId;
	}

	/** full constructor */
	public Student(String studentId, Clas clas, String studentName, String sex,
			String birthday, String password, String phone, String adress,
			Set<Grade> grades)
	{
		this.studentId = studentId;
		this.clas = clas;
		this.studentName = studentName;
		this.sex = sex;
		this.birthday = birthday;
		this.password = password;
		this.phone = phone;
		this.adress = adress;
		this.grades = grades;
	}

	// Property accessors
	@Id
	@Column(name = "studentID", unique = true, nullable = false, length = 100)
	public String getStudentId()
	{
		return this.studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clasID")
	public Clas getClas()
	{
		return this.clas;
	}

	public void setClas(Clas clas)
	{
		this.clas = clas;
	}

	@Column(name = "studentName", length = 100)
	public String getStudentName()
	{
		return this.studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	@Column(name = "sex", length = 100)
	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Column(name = "birthday", length = 100)
	public String getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	@Column(name = "password", length = 100)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "phone", length = 100)
	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "adress", length = 100)
	public String getAdress()
	{
		return this.adress;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Grade> getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set<Grade> grades)
	{
		this.grades = grades;
	}

}