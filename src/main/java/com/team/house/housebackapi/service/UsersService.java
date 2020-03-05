package com.team.house.housebackapi.service;

import com.team.house.housebackapi.entity.Users;

import java.util.List;

public interface UsersService {
    public int regUser(Users users);
    public Users loginUer(String name,String password);
}
