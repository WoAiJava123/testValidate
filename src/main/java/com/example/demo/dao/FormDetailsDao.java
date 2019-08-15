package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entitys.FormDetails;

@Mapper
public interface FormDetailsDao {

	//public boolean addClounmnInfo(ClounmnInfo dept);

	public FormDetails getEntity(Integer form_id);
	public int insertEnetity(FormDetails formDetails);

	//public List<ClounmnInfo> findAll();
}
