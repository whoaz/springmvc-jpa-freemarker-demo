package com.yida.demo.service.impl;

import com.yida.demo.entity.City;
import com.yida.demo.repositories.CityRepository;
import com.yida.demo.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by helloz on 2016/7/27.
 */
@Service
public class CityServiceImpl implements CityService {

    public CityServiceImpl() {
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
        System.out.println("=========CityService=====");
    }

    @Resource
    private CityRepository cityRepository;


    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
