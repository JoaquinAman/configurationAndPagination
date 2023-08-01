package com.example.propertiestest.controller;

import com.example.propertiestest.model.Firstdata;
import com.example.propertiestest.model2.Seconddata;
import com.example.propertiestest.repository.IFirstDataRepository;
import com.example.propertiestest.repository2.ISecondDataRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/mydata")
public class MyDataController {

//    @Qualifier("datasource")
//    @Autowired
//    DataSource dataSource;
//    @Qualifier("datasource2")
//    @Autowired
//    DataSource dataSource2;

    @Autowired
    IFirstDataRepository firstDataRepository;
    @Autowired
    ISecondDataRepository secondDataRepository;

    @GetMapping("/saveData")
    public String saveData() {
        String name = "myName";
        firstDataRepository.save(new Firstdata(name));
        secondDataRepository.save(new Seconddata(name));
        return "saved";
    }

    @GetMapping("/getData")
    public List<Seconddata> getData() {
        return secondDataRepository.findAll();
    }

    @PostMapping("/saveDataSecondDataRepo")
    public void saveDataSecondDataRepo(@RequestBody Seconddata seconddata) {
        Seconddata seconddata1 = new Seconddata();
        seconddata1.setName(seconddata.getName());
        secondDataRepository.save(seconddata1);
    }

    @GetMapping("/getPaginated")
    public Page<Seconddata> getPaginated(@RequestParam int page, @RequestParam int size) {
        return secondDataRepository.findAll(PageRequest.of(page, size));
    }

//    @PostMapping("/{bd}")
//    public void saveData(@PathVariable String bd) {
//        String name = "myName";
//        if(bd.equals("first")) {
//            firstDataRepository.save(new Firstdata(name));
//        } else if(bd.equals("second")) {
//            secondDataRepository.save(new Seconddata(name));
//        }
//    }
}
