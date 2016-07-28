package com.yida.demo.service.impl;

import com.yida.demo.entity.City;
import com.yida.demo.repositories.CityRepository;
import com.yida.demo.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by helloz on 2016/7/27.
 */
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityRepository cityRepository;


    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }


    @Override
    public Page<City> findByPage(Pageable pageable) {

        return cityRepository.findAll(pageable);
    }
}
