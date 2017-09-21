package com.liying.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "grade", catalog = "db_banjiguanli")
public class Grade implements java.io.Serializable
{

	// Fields

	private GradeId id;
	private Course course;
	private Student student;
	private String grade;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** minimal constructor */
	public Grade(GradeId id, Course course, Student student)
	{
		this.id = id;
		this.course = course;
		this.student = student;
	}

	/** full constructor */
	public Grade(GradeId id, Course course, Student student, String grade)
	{
		this.id = id;
		this.course = course;
		this.student = student;
		this.grade = grade;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "studentId", column = @Column(name = "studentID", nullable = false, length = 100)),
			@AttributeOverride(name = "courseId", column = @Column(name = "courseID", nullable = false, length = 100)) })
	public GradeId getId()
	{
		return this.id;
	}

	public void setId(GradeId id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseID", nullable = false, insertable = false, updatable = false)
	public Course getCourse()
	{
		return this.course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentID", nullable = false, insertable = false, updatable = false)
	public Student getStudent()
	{
		return this.student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	@Column(name = "grade", length = 100)
	public String getGrade()
	{
		return this.grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

}