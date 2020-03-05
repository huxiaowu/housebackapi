package com.team.house.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.FileUploadUtil;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PagePrameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(value = "*",allowCredentials ="true")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/addHouse")
    public String addHouse(House house, HttpSession session, @RequestParam(name = "pFile",required = false) MultipartFile file){
        try {
            //文件上传
            String path="D:\\images";
          String fileName=  FileUploadUtil.upload(file,path);
          house.setPath(fileName);
            //设置编号
            house.setId(System.currentTimeMillis() + "");
            //手动添加用户编号
            Users users = (Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            int temp = houseService.addHouse(house);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
           return "{\"result\":0}";
}
    @RequestMapping("/getHouseByPage")
    public PageInfo<House> getHouseByPage(PagePrameter pagePrameter,HttpSession session){
        Users users = (Users) session.getAttribute("logininfo");
       PageInfo<House>pageInfo=houseService.getHouseByUserId(users.getId(),pagePrameter);
       return pageInfo;
    }

@RequestMapping("/deleHouse")
    public String deleHouse(String id,String fileName){
        int temp=houseService.deleHouse(id);
        if(temp>0){
            File file=new File("D:\\images\\"+fileName);
            if(file.exists()){
                file.delete();
            }
            return "{\"result\":1}";
        }
        else{
            return "{\"result\":0}";
        }
}
@RequestMapping("/searchHouse")
    public PageInfo<House> searchHouse(HouseCondition houseCondition){
      PageInfo<House>pageInfo=houseService.getBroswerHouse(houseCondition);
      return pageInfo;
}
}
