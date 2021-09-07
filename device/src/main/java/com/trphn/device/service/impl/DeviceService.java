package com.trphn.device.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.UUID;

import com.trphn.device.dao.Dao;
import com.trphn.device.model.Device;
import com.trphn.device.service.IService;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeviceService implements IService<Device>{
    private final Dao<Device> deviceDao;

    @Override
    public Device create(Device device) {
        log.info("DeviceService - save {}", device.toString());
        return deviceDao.create(device);
    }

    @Override
    public Device findById(UUID id) {
        log.info("DeviceService - findById {}", id.toString());
        return deviceDao.findById(id);
    }

    @Override
    public Collection<Device> findAll() {
        log.info("DeviceService - findAll");
        return deviceDao.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        log.info("DeviceService - deleteById {}", id.toString());
        deviceDao.deleteById(id);
    }

    @Override
    public Collection<Device> filter(String brand, String name) {
        log.info("DeviceService - search");
        return deviceDao.filter(brand, name);
    }

    @Override
    public Device update(Device device) {
        log.info("DeviceService - deleteById {}", device.toString());
        return deviceDao.update(device);
    }

}
