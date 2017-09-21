package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Clas;
import com.liying.service.ClassManager;
import com.opensymphony.xwork2.ActionSupport;
@Component("classAction")
@Scope
public class ClassAction extends ActionSupport
{
	//变量***********************************************************************
	private Clas clas;
	private String clasId;
	private String clasName;
	//状态变量（返回给客户端判断操作是否成功）
	private int state;
	//注入变量
	private ClassManager classManager;
	//普通变量
	private List<Clas> cList = new ArrayList<Clas>();//用于返回所有的班级信息
	//方法***********************************************************************
	//返回所有班级信息
	public String allClassInfo()
	{
		this.cList = classManager.getClassInfo();
		return "success";
	}
	//添加班级
	public String addClass()
	{
		clas=new Clas();
		clas.setClasId(clasId);
		clas.setClasName(clasName);
		if(classManager.addClass(clas))
		{
			state=1;
		}
		else {
			state=0;
		}
		return "success";
	}
	//编辑班级信息页面
	public String editClassInfo()
	{
		//System.out.println(clasId);
		this.clas=classManager.getEditClasInfo(clasId);
		return "success";
	}
	//修改班级信息
	public String updateClassInfo()
	{
		clas=new Clas();
		clas.setClasId(clasId);
		clas.setClasName(clasName);
		System.out.println(clasId+clasName);
		if(classManager.updateClasInfo(clas))
		{
			state=1;
		}
		else {
			state=0;
		}
		return "success";
	}
	//删除班级
	public String deleteClass()
	{
		System.out.println(clasId);
		if(classManager.deleteClasInfo(clasId))
		{
			state=1;
		}
		else {
			state=0;
		}
		return "success";
	}
	//set和get******************************************************************
	public ClassManager getClassManager()
	{
		return classManager;
	}
	@Resource
	public void setClassManager(ClassManager classManager)
	{
		this.classManager = classManager;
	}
	public List<Clas> getCList()
	{
		return cList;
	}
	public void setCList(List<Clas> cList)
	{
		this.cList = cList;
	}
	public String getClasId()
	{
		return clasId;
	}
	public String getClasName()
	{
		return clasName;
	}
	public void setClasId(String clasId)
	{
		this.clasId = clasId;
	}
	public void setClasName(String clasName)
	{
		this.clasName = clasName;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public Clas getClas()
	{
		return clas;
	}
	public void setClas(Clas clas)
	{
		this.clas = clas;
	}
}
