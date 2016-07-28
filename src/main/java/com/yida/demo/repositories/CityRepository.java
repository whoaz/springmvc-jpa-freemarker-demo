package com.yida.demo.repositories;

import com.yida.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by helloz on 2016/7/27.
 */
@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
}
