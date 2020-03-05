package com.team.house.housebackapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PagePrameter;

import java.util.List;

public interface HouseService {
    public int addHouse(House house);
    public PageInfo<House>getHouseByUserId(Integer id,PagePrameter pagePrameter);
    public int deleHouse(String id);
    public PageInfo<House>getBroswerHouse(HouseCondition houseCondition);
}
