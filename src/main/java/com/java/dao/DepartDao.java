package com.java.dao;

import com.java.entity.Departs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartDao extends JpaRepository<Departs,String> {

}
