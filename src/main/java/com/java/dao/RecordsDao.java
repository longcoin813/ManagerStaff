package com.java.dao;

import com.java.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsDao extends JpaRepository<Records,Integer> {
}
