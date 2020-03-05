package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.District;
import com.team.house.housebackapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowCredentials ="true")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getAllDis")
    public List<District> getAllDis(){

      List<District> list= districtService.getAllDistrict();
      return list;
    }
}
