package com.yida.demo.controller;

import com.yida.demo.entity.City;
import com.yida.demo.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView showCityPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        ModelAndView mv = new ModelAndView();
        Page<City> cities = cityService.findByPage(pageable);
        int numberOfElements = cities.getNumberOfElements();
        System.out.println("numberOfElements = " + numberOfElements);

        mv.addObject("cities", cities);
        mv.setViewName("all");
        return mv;
    }



}
