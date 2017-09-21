package com.liying.service;

import java.util.List;

import com.liying.model.Clas;

public interface ClassManager
{
	public List<Clas> getClassInfo();//得到所有的班级信息
	public boolean addClass(Clas clas);//添加班级
	public Clas getEditClasInfo(String ClasId);//得到要编辑的班级信息
	public boolean updateClasInfo(Clas clas);//修改班级信息
	public boolean deleteClasInfo(String clasId);//删除班级
}
