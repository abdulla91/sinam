package com.company.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Data;
import com.company.repository.DataRepository;
import com.company.service.DataService;

@Service
@Transactional
public class DataServiceImpl implements DataService{

	@Autowired
	DataRepository dataRepo;

	@Override
	public List<Data> listAll(Integer id) {
		return dataRepo.findDataByUserId(id);
	}

	@Override
	public void save(Data data) {
		dataRepo.save(data);	
	}

	@Override
	public Data getDataById(Integer id) {
		return dataRepo.findById(id).get();
	}

	@Override
	public void deleteData(Integer id) {
		dataRepo.deleteById(id);		
	}

}
