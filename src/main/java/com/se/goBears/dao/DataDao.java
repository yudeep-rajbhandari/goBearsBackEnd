package com.se.goBears.dao;


import com.se.goBears.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataDao extends JpaRepository<Data, Long> {

    Data findDataById(long id);

}
