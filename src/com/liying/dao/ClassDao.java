package com.liying.dao;

import java.util.List;

import com.liying.model.Clas;

public interface ClassDao
{
	public List<Clas> findClassInfo();//找出所有班级信息
	public boolean saveClass(Clas clas);//保存班级
	public Clas queryEditClasInfo(String clasId);//查询要编辑的班级信息
	public boolean updateClasInfo(Clas clas);//修改班级信息
	public boolean deleteClasInfo(String clasId);//删除班级
}
