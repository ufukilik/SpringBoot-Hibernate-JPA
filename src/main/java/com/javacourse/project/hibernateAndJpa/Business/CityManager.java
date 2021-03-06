package com.javacourse.project.hibernateAndJpa.Business;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CityManager implements ICityService {

    private ICityDal cityDal;

    @Autowired
    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        return this.cityDal.getAll();
    }

    @Override
    @Transactional
    public Integer add(City city) {
        this.cityDal.add(city);
        return city.getId();
    }

    @Override
    @Transactional
    public void update(City city) {
        this.cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.cityDal.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id) {
        return this.cityDal.getById(id);
    }
}
