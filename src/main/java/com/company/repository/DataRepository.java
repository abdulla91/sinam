package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{
	@Query("SELECT d FROM Data d WHERE user.uId = :id")
	List<Data> findDataByUserId(@Param("id") Integer id);
}
