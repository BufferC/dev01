package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbMusicServiceImpl implements TbMusicService {
    //声明Dao层接口
    @Autowired
    private TbMusicMapper musicMapper;

    @Override
    public List<TbMusic> findAll() {
        //不带条件查询全部
        return musicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId = musicMapper.findMaxId();

        if (musicId != maxId){
            musicId++;
        }else {
            musicId = 1;
        }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer maxId = musicMapper.findMaxId();
        if (musicId != 1){
            musicId --;
        }else {
            musicId = maxId;
        }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {

        TbMusicExample tbMusicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();

        TbMusicExample.Criteria or = tbMusicExample.or();

        criteria.andMusicNameLike("%"+keyword+"%");

        or.andMusicArtistNameLike("%"+keyword+"%");

        return musicMapper.selectByExample(tbMusicExample);
    }
}
