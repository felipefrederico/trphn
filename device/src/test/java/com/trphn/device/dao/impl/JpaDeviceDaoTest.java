package com.trphn.device.dao.impl;

import com.trphn.device.model.Device;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

@SpringBootTest
public class JpaDeviceDaoTest {

    @Autowired
    private JpaDeviceDao underTest;

    @Test
    void testDelete() {
    
    }   

    @Test
    void testFilter() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {
        
        Device device = new Device();
        device.setName("UnderSaveTestDeviceName");
        device.setBrand("UnderSaveTestDeviceBrand");
        
        
        underTest.save(device);

        int actual = underTest.findAll().size();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testUpdate() {
        Device device = new Device();
        device.setName("UnderDeleteTestDeviceName");
        device.setBrand("UnderDeleteTestDeviceBrand");
        
        UUID id = underTest.save(device).getId();

        underTest.delete(id);

        int actual = underTest.findAll().size();
        int expected = underTest.findAll().size()-1;

        assertThat(actual).isEqualTo(expected);
    }
}
