package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GradeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class GradeId implements java.io.Serializable
{

	// Fields

	private String studentId;
	private String courseId;

	// Constructors

	/** default constructor */
	public GradeId()
	{
	}

	/** full constructor */
	public GradeId(String studentId, String courseId)
	{
		this.studentId = studentId;
		this.courseId = courseId;
	}

	// Property accessors

	@Column(name = "studentID", nullable = false, length = 100)
	public String getStudentId()
	{
		return this.studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	@Column(name = "courseID", nullable = false, length = 100)
	public String getCourseId()
	{
		return this.courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GradeId))
			return false;
		GradeId castOther = (GradeId) other;

		return ((this.getStudentId() == castOther.getStudentId()) || (this
				.getStudentId() != null && castOther.getStudentId() != null && this
				.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getCourseId() == castOther.getCourseId()) || (this
						.getCourseId() != null
						&& castOther.getCourseId() != null && this
						.getCourseId().equals(castOther.getCourseId())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result
				+ (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37 * result
				+ (getCourseId() == null ? 0 : this.getCourseId().hashCode());
		return result;
	}

}