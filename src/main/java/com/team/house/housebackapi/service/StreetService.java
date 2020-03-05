package com.team.house.housebackapi.service;

import com.team.house.housebackapi.entity.Street;

import java.util.List;

public interface StreetService {
    public List<Street>getStreetByID(Integer id);
}
