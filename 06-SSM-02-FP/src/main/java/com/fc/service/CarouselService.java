package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVo;

public interface CarouselService {
    ResultVo getList(Integer pageNo, Integer pageSize, String name);

    ResultVo add(Carousel carousel);

    ResultVo update(Carousel carousel);

    ResultVo delete(int id);
}
