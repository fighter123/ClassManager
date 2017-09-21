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
 * Clas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clas", catalog = "db_banjiguanli")
public class Clas implements java.io.Serializable
{

	// Fields

	private String clasId;
	private String clasName;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Clas()
	{
	}

	/** minimal constructor */
	public Clas(String clasId)
	{
		this.clasId = clasId;
	}

	/** full constructor */
	public Clas(String clasId, String clasName, Set<Student> students)
	{
		this.clasId = clasId;
		this.clasName = clasName;
		this.students = students;
	}

	// Property accessors
	@Id
	@Column(name = "clasID", unique = true, nullable = false, length = 100)
	public String getClasId()
	{
		return this.clasId;
	}

	public void setClasId(String clasId)
	{
		this.clasId = clasId;
	}

	@Column(name = "clasName", length = 100)
	public String getClasName()
	{
		return this.clasName;
	}

	public void setClasName(String clasName)
	{
		this.clasName = clasName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clas")
	public Set<Student> getStudents()
	{
		return this.students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

}