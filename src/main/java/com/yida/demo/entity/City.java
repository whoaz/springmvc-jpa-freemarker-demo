package com.yida.demo.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by helloz on 2016/7/27.
 */
@Entity
@Table(name = "city")
public class City implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    @NotEmpty(message = "城市名称不能为空")
    private String name;

    @Column
    @NotEmpty(message = "区域编码不能为空")
    private String countryCode;

    @Column
    @NotEmpty(message = "区域不能为空")
    private String district;

    @Column
    @NotEmpty(message = "人口不能为空")
    private Integer population;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
