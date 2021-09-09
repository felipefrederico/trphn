package com.trphn.device.resource.impl;

import com.trphn.core.model.Device;
import com.trphn.core.service.IService;
import com.trphn.device.resource.Resource;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("v1/admin/device")
@RestController
@RequiredArgsConstructor
@Slf4j
public class DeviceResource implements Resource<Device>{
    private final IService<Device> service;

    @Override
    public ResponseEntity<Device> create(Device device) {
        log.info("DeviceResourceImpl - create {}", device.toString());
        return new ResponseEntity<>(service.create(device), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Device> findById(UUID id) {
        log.info("DeviceResourceImpl - findById {}", id.toString());
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Device>> findAll() {
        log.info("DeviceResourceImpl - findAll");
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Device> update(Device device) {
        log.info("DeviceResourceImpl - update {}", device.toString());
        return new ResponseEntity<>(service.update(device), HttpStatus.ACCEPTED );
    }

    @Override
    public ResponseEntity<Device> patch(UUID id, Map<String, String> fields) {
        log.info("DeviceResourceImpl - patch {}", id.toString());
        Device device = service.findById(id);
        if (device!=null){
            fields.forEach((k,v)->{
                if (k.equals("name") && v!=null) device.setName(v);
                if (k.equals("brand") && v!=null) device.setBrand(v);
            });
        }
        return new ResponseEntity<>(service.update(device), HttpStatus.ACCEPTED );
    }

    @Override
    public ResponseEntity<String> deleteById(UUID id) {
        log.info("DeviceResourceImpl - update {}", id.toString());
        service.deleteById(id);
        return new ResponseEntity<>("Device "+ id +" deleted successfully", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Collection<Device>> filter(String brand, String name) {
        log.info("DeviceResourceImpl - filter ");
        return new ResponseEntity<>(service.filter(brand, name), HttpStatus.OK);
    }

}