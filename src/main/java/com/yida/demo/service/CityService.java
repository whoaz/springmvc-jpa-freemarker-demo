package com.yida.demo.service;

import com.yida.demo.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by helloz on 2016/7/27.
 */
public interface CityService {

    List<City> findAll();

    Page<City> findByPage(Pageable pageable);

}
