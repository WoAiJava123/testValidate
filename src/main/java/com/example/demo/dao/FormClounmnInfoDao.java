package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entitys.FormClounmnInfo;

@Mapper
public interface FormClounmnInfoDao {

	//public boolean addClounmnInfo(ClounmnInfo dept);

	public List<FormClounmnInfo> findList(int form_id);

	//public List<ClounmnInfo> findAll();
}
