package com.company.service;

import java.util.List;

import com.company.entity.Data;


public interface DataService {
	
	List<Data> listAll(Integer id);
	void save(Data data);
	Data getDataById(Integer id);
	void deleteData(Integer id);
}
