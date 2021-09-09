package com.trphn.device.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.trphn.core.dao.Dao;
import com.trphn.core.model.Device;
import com.trphn.device.exceptions.DeviceNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JpaDeviceDaoImpl implements Dao<Device> {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    @Transactional
    public Device create(Device device) {
       log.info("JpaDeviceDao - Save {}", device);
        entityManager.persist(device);
        entityManager.flush();
       return device;
    }

    @Transactional
    public Device update(Device device) {
        log.info("JpaDeviceDao - update {}", device);
        Optional<Device> managedDevice = Optional.ofNullable( findById(device.getId()) );
        if (managedDevice.isEmpty()) throw new DeviceNotFoundException("Device Not Found");

        managedDevice.get().setName(device.getName());
        managedDevice.get().setBrand(device.getBrand());
        entityManager.merge(managedDevice.get());
        entityManager.flush();        
        return managedDevice.get();
    }


    @Override
    public Collection<Device> findAll() {
        log.info("JpaDeviceDao - findAll");
        Query query = entityManager.createQuery("SELECT d FROM Device d", Device.class);
        return query.getResultList();
    }

    @Override
    public Device findById(UUID id) {
        log.info("JpaDeviceDao - findById {}", id);
        return entityManager.find(Device.class, id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        log.info("JpaDeviceDao - delete {}", id);
        Optional<Device> device = Optional.ofNullable( findById(id) );
        if (device.isEmpty()) throw new DeviceNotFoundException("Device Not Found");

        entityManager.remove(device.get());
        entityManager.flush();
    }

    @Override
    public Collection<Device> filter(String brand, String name){
        log.info("JpaDeviceDao - filter");

        String query = "select D from Device D ";
        String condition = "where ";

        if(brand!=null){
            query += condition + "D.brand like CONCAT('%',:brand,'%')";
            condition = "and ";
        }

        if(name!=null){
            query += condition + "D.name like CONCAT('%',:name,'%')";
        }

        Query q = entityManager.createQuery(query, Device.class);
        
        if(brand!=null){
           q.setParameter("brand", brand);
        }

        if(name!=null){
            q.setParameter("name", name);
        }

        return q.getResultList();
    }
    
}
