package com.fc.service.impl;

import com.fc.dao.LocationDao;
import com.fc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDao;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void add(String location) {
        locationDao.add(location);
    }
}
