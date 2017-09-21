package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.ClassDao;
import com.liying.model.Clas;
import com.liying.service.ClassManager;
@Component
public class ClassManagerImpl implements ClassManager
{
	//变量注入***********************************************************************
	private ClassDao classDao;
	public ClassDao getClassDao()
	{
		return classDao;
	}
	@Resource
	public void setClassDao(ClassDao classDao)
	{
		this.classDao = classDao;
	}
	//重载方法*********************************************************************
	@Override
	public List<Clas> getClassInfo()
	{
		// TODO Auto-generated method stub
		return classDao.findClassInfo();
	}
	@Override
	public boolean addClass(Clas clas)
	{
		// TODO Auto-generated method stub
		return classDao.saveClass(clas);
	}
	@Override
	public Clas getEditClasInfo(String clasId)
	{
		// TODO Auto-generated method stub
		return classDao.queryEditClasInfo(clasId);
	}
	@Override
	public boolean updateClasInfo(Clas clas)
	{
		// TODO Auto-generated method stub
		return classDao.updateClasInfo(clas);
	}
	@Override
	public boolean deleteClasInfo(String clasId)
	{
		// TODO Auto-generated method stub
		return classDao.deleteClasInfo(clasId);
	}

}
