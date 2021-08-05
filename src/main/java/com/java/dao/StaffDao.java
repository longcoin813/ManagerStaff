package com.java.dao;

import com.java.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staffs, String> {
}
