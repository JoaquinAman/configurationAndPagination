package com.example.propertiestest.repository2;

import com.example.propertiestest.model2.Seconddata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//use datasource2

@Repository
public interface ISecondDataRepository extends JpaRepository<Seconddata, Long> {
}
