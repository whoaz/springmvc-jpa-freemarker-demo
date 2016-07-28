package com.yida.demo.controller;

import com.yida.demo.entity.City;
import com.yida.demo.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by helloz on 2016/7/27.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping("/all")
    public ModelAndView showCity() {
        ModelAndView mv = new ModelAndView();
        List<City> cities = cityService.findAll();
        mv.addObject("cities", cities);
        mv.setViewName("all");
        return mv;
    }


}
