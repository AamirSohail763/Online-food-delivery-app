package com.foodapp.authrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.authmodels.LogInModel;


@Repository
public interface LogInModelDAO extends JpaRepository<LogInModel, Integer>{

}
