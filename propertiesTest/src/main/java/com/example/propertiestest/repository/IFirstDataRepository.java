package com.example.propertiestest.repository;

import com.example.propertiestest.model.Firstdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFirstDataRepository extends JpaRepository<Firstdata, Long> {
}
