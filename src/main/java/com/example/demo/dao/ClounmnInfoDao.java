package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entitys.ClounmnInfo;

@Mapper
public interface ClounmnInfoDao {

	//public boolean addClounmnInfo(ClounmnInfo dept);

	public ClounmnInfo findById(Integer id);

	//public List<ClounmnInfo> findAll();
}
