package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        return null;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        List<PoorWithBLOBs> poor;

        ResultVO resultVO;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);

                poor = poorMapper.selectByExampleWithBLOBs(null);
            } else {
                PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);
                poor = new ArrayList<>();
                poor.add(poorWithBLOBs);

                // 如果调用了findById，应该对点击量进行加1操作
                click(poorWithBLOBs.getId(), null);
            }

            PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poor);

            DataVO<PoorWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(), poor, pageNum, pageSize);

            resultVO = new ResultVO(200, "贫困户获取成功", true, dataVO);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO(-1000, "贫困户获取失败", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO add(PoorWithBLOBs poor) {
        if (poor.getCreateTime() == null) {
            poor.setCreateTime(new Date());
        }

        // 刚刚创建出来的扶贫政策点击量应该为0
        poor.setClickNum(0);
        poor.setLastClickTime(null);

        int affectedRows = poorMapper.insertSelective(poor);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "贫困户添加成功", true, poor);
        } else {
            resultVO = new ResultVO(-1000, "贫困户添加失败", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poor) {
        return null;
    }

    @Override
    public ResultVO delete(Long id) {
        return null;
    }
}
