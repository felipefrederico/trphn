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
    void testSave() {
        
        Device device = new Device();
        device.setName("UnderSaveTestDeviceName");
        device.setBrand("UnderSaveTestDeviceBrand");
              
    
        Device actual = underTest.save(device);
        Device expected = underTest.findById(device.getId());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDelete() {
        Device device = new Device();
        device.setName("UnderDeleteTestDeviceName");
        device.setBrand("UnderDeleteTestDeviceBrand");
        UUID id = underTest.save(device).getId();

        underTest.delete(id);

        Device actual = underTest.findById(device.getId());

        assertThat(actual).isNull();
    }   

    @Test
    void testFilter() {
        Device deviceA = new Device();
        deviceA.setName("UnderTestFilterDeviceAName");
        deviceA.setBrand("UnderTestFilterDeviceABrand");
        underTest.save(deviceA);
       
        int actual = underTest.filter(null, "UnderTestFilterDeviceA").size();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testFindAll() {

        int sizeBeforeSave = underTest.findAll().size();
        underTest.save(new Device(null,"UnderTestFindAllDeviceAName","UnderTestFindAllDeviceABrand", null));
    
        int actual = underTest.findAll().size();
        int expected = sizeBeforeSave+1;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testFindById() {
        Device device = new Device();
        device.setName("UnderFindByIdTestDeviceName");
        device.setBrand("UnderFindByIdTestDeviceBrand");
        
    
        Device actual =  underTest.save(device);
        Device expected = underTest.findById(actual.getId());

        assertThat(actual).isEqualTo(expected);
    }

    

    @Test
    void testUpdate() {
        Device deviceToSave = new Device();
        deviceToSave.setName("UnderUpdateTestDeviceName");
        deviceToSave.setBrand("UnderUpdateTestDeviceBrand");    
        Device deviceToUpdate =  underTest.save(deviceToSave);

        
        String expectedName = "UnderUpdateTestDeviceNewName";
        String expectedBrand = "UnderUpdateTestDeviceNewBrand";
        
        deviceToUpdate.setName(expectedName);
        deviceToUpdate.setBrand(expectedBrand);
        underTest.update(deviceToUpdate);

        Device updatedDevice = underTest.findById(deviceToUpdate.getId());

        String actualName = updatedDevice.getName();
        String actialBrand = updatedDevice.getBrand();

        assertThat(actualName).isEqualTo(expectedName);
        assertThat(expectedBrand).isEqualTo(actialBrand);
    }
}
