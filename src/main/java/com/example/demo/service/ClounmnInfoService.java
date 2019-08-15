package com.example.demo.service;
 
import java.util.List;

import com.example.demo.entitys.ClounmnInfo;
 
public interface ClounmnInfoService {
	
  public boolean add(ClounmnInfo dept);
  public ClounmnInfo  get(Long id);
  public List<ClounmnInfo> list();
  
}
 

