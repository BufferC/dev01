package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize, int id) {
        List<Carousel> arrayList;
        PageInfo<Carousel> userPageInfo;
        ResultVo resultVo ;

        try {
            if (id == 0){
                PageHelper.startPage(pageNo, pageSize);
                arrayList = carouselMapper.selectByExample(null);
            }else {
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);
                arrayList = new ArrayList<>();
                if(carousel != null){
                    arrayList.add(carousel);
                }
            }
            //DataVo<Object> dataVo = new DataVo<>();
            userPageInfo = new PageInfo<>(arrayList);
            if (userPageInfo.getPageNum() != 0) {
                resultVo = new ResultVo("获取成功!", userPageInfo, true, 200);
            }else {
                resultVo = new ResultVo("获取失败!",null,false,404);
            }
        }catch (Exception e){
            resultVo = new ResultVo("获取异常!",null,false,500);
        }

        return resultVo;
    }

    @Override
    public ResultVo add(Carousel carousel) {
        ResultVo resultVo;
        int affection = carouselMapper.insertSelective(carousel);
        if (affection == 1){
            resultVo = new ResultVo("添加成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("添加失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        ResultVo resultVo;
        int affection = carouselMapper.updateByPrimaryKeySelective(carousel);
        if (affection == 1){
            resultVo = new ResultVo("用户修改成功!",carouselMapper.selectByPrimaryKey(carousel.getId()),true,200);
        }else {
            resultVo = new ResultVo("用户修改失败!", null, false, 404);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(int id) {
        ResultVo resultVo;
        int affection = carouselMapper.deleteByPrimaryKey(id);
        if (affection == 1){
            resultVo = new ResultVo("删除成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("删除失败!",null,false,404);
        }
        return resultVo;
    }
}
