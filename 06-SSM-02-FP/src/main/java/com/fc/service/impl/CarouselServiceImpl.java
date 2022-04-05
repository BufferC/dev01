package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> getList(String pageNo, String pageSize, String id) {
        List<Carousel> carousels = new ArrayList<>();
        if (id == null || id.equals("")){
            PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            carousels = carouselMapper.selectByExample(null);
        }else {
            carousels.add(carouselMapper.selectByPrimaryKey(Integer.valueOf(id)));
        }

        return carousels;
    }

    @Override
    public long count() {
        return carouselMapper.countByExample(null);
    }

    @Override
    public Carousel add(Carousel carousel) {
        int i = carouselMapper.insertSelective(carousel);
        if (i == 1){
            return carousel;
        }
        return null;
    }

    @Override
    public Carousel update(int id, String name, String picture, Integer available) {
        Carousel carousel = carouselMapper.selectByPrimaryKey(id);
        if (name != null){
            carousel.setName(name);
        }
        if (picture != null){
            carousel.setPicture(picture);
        }
        if (available != null){
            carousel.setAvailable(true);
        }else {
            carousel.setAvailable(false);
        }
        int i = carouselMapper.updateByPrimaryKey(carousel);
        if (i == 1){
            return carousel;
        }
        return null;
    }

    @Override
    public int delete(String id) {
        return carouselMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }
}
