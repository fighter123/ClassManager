package com.liying.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "db_banjiguanli")
public class Course implements java.io.Serializable
{

	// Fields

	private String courseId;
	private String courseName;
	private String courseProperty;
	private String courseCredits;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String courseId)
	{
		this.courseId = courseId;
	}

	/** full constructor */
	public Course(String courseId, String courseName, String courseProperty,
			String courseCredits, Set<Grade> grades)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseProperty = courseProperty;
		this.courseCredits = courseCredits;
		this.grades = grades;
	}

	// Property accessors
	@Id
	@Column(name = "courseID", unique = true, nullable = false, length = 100)
	public String getCourseId()
	{
		return this.courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	@Column(name = "courseName", length = 100)
	public String getCourseName()
	{
		return this.courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	@Column(name = "courseProperty", length = 100)
	public String getCourseProperty()
	{
		return this.courseProperty;
	}

	public void setCourseProperty(String courseProperty)
	{
		this.courseProperty = courseProperty;
	}

	@Column(name = "courseCredits", length = 100)
	public String getCourseCredits()
	{
		return this.courseCredits;
	}

	public void setCourseCredits(String courseCredits)
	{
		this.courseCredits = courseCredits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Grade> getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set<Grade> grades)
	{
		this.grades = grades;
	}

}