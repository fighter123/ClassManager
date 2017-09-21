package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.GradeDao;
import com.liying.model.CourseGrade;
import com.liying.model.Grade;
import com.liying.model.StudentGrade;
@Component
public class GradeDaoImpl implements GradeDao
{
	private HibernateTemplate hibernateTemplate;
	
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
	public boolean saveGrade(Grade grade)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(grade);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public List<StudentGrade> returnTheStudentGrades(String studentId)
	{
		System.out.println("123");
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select new com.liying.model.StudentGrade(g.grade, g.id.courseId, c.courseName, c.courseProperty,c.courseCredits)" +
				"from Grade g, Course c where  g.course=c.courseId and g.id.studentId='"+studentId+"' ";
		Query query = session.createQuery(hql); 
		System.out.println(query.list());
		List<StudentGrade> studentGrades = query.list(); 
        return studentGrades;
	}
	@Override
	public String returnZongXueFen(String studentId)
	{
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select sum(c.courseCredits)" +
				"from Grade g, Course c where  g.course=c.courseId and g.id.studentId='"+studentId+"'and g.grade>=60 ";
		Query query = session.createQuery(hql); 
		//String zongXueFen=query.toString();
		System.out.println(query.list());
		List<String> list=query.list();
		String zongxuefen=list.get(0);
		//System.out.println(zongxuefen);
		return zongxuefen;
	}
	@Override
	public List<CourseGrade> returnTheCourseGrades(String courseId)
	{
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select new com.liying.model.CourseGrade(s.studentId,s.studentName,g.grade)" +
				"from Grade g, Student s where  g.student=s.studentId and g.id.courseId='"+courseId+"' ";
		Query query = session.createQuery(hql); 
		System.out.println(query.list());
		List<CourseGrade> courseGrades = query.list(); 
        return courseGrades;
	}
	@Override
	public String returnTheCourseMaxGrade(String courseId)
	{
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select max(g.grade)" +
				"from Grade g, Student s where  g.student=s.studentId and g.id.courseId='"+courseId+"' ";
		Query query = session.createQuery(hql); 
		//String zongXueFen=query.toString();
		System.out.println(query.list());
		List<String> list=query.list();
		String zuigaofen=list.get(0);
		//System.out.println(zongxuefen);
		return zuigaofen;
	}
	@Override
	public String returnTheCourseMinGrade(String courseId)
	{
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select min(g.grade)" +
				"from Grade g, Student s where  g.student=s.studentId and g.id.courseId='"+courseId+"' ";
		Query query = session.createQuery(hql); 
		//String zongXueFen=query.toString();
		System.out.println(query.list());
		List<String> list=query.list();
		String zuidifen=list.get(0);
		//System.out.println(zongxuefen);
		return zuidifen;
	}
	@Override
	public String returnTheCoursePingjunGrade(String courseId)
	{
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select avg(g.grade)" +
				"from Grade g, Student s where  g.student=s.studentId and g.id.courseId='"+courseId+"' ";
		Query query = session.createQuery(hql); 
		//String zongXueFen=query.toString();
		//System.out.println(query.list());
		List<String> list=query.list();
		//System.out.println(list.toString());
		String pingjunfen= list.toString();
		pingjunfen=pingjunfen.substring(1,pingjunfen.length()-1);
		//System.out.println(pingjunfen);
		return pingjunfen;
	}
	@Override
	public String returnTheCourseBujige(String courseId)
	{
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select count(*)" +
				"from Grade g, Student s where  g.student=s.studentId and g.id.courseId='"+courseId+"'and g.grade<60 ";
		Query query = session.createQuery(hql); 
		//String zongXueFen=query.toString();
		List<String> list=query.list();
		String bujige=list.toString();
		bujige=bujige.substring(1,bujige.length()-1);
		//System.out.println(zongxuefen);
		return bujige;
	}

}
