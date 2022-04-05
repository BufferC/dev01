package com.fc.service;

import com.fc.entity.Carousel;

import java.util.List;

public interface CarouselService {
    List<Carousel> getList(String pageNo, String pageSize, String id);

    long count();

    Carousel add(Carousel carousel);

    Carousel update(int id, String name, String picture, Integer available);

    int delete(String id);
}
