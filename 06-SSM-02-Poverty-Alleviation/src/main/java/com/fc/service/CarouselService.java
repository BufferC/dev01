package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVO;

public interface CarouselService {
    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

    ResultVO add(Carousel carousel);

    ResultVO update(Carousel carousel);

    ResultVO delete(Integer id);

    ResultVO changeStatus(Integer id);
}
