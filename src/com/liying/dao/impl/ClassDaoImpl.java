package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.ClassDao;
import com.liying.model.Clas;
@Component
public class ClassDaoImpl implements ClassDao
{
	//hibernateTemplate注入******************************************************
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
	//重载方法*********************************************************************
	@Override
	public List<Clas> findClassInfo()
	{
		// TODO Auto-generated method stub
		List<Clas> cList = hibernateTemplate.find("from Clas");
		return cList;
	}
	@Override
	public boolean saveClass(Clas clas)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(clas);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Clas queryEditClasInfo(String clasId)
	{
		// TODO Auto-generated method stub
		Clas clas = (Clas)hibernateTemplate.get(Clas.class, clasId);
		return clas;
	}
	@Override
	public boolean updateClasInfo(Clas clas)
	{
		// TODO Auto-generated method stub
		System.out.println("进入service");
		try
		{
			hibernateTemplate.update(clas.getClasId(),clas);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean deleteClasInfo(String clasId)
	{
		//System.out.println("进入删除班级dao");
		//System.out.println(clasId);
		// TODO Auto-generated method stub
		try
		{
			Clas clas = (Clas)hibernateTemplate.get(Clas.class, clasId);
			//System.out.println(clas.getClasId()+";"+clas.getClasName());
			hibernateTemplate.delete(clas);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}

}
