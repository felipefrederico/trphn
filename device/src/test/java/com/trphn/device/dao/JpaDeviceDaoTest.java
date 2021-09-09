package com.trphn.device.dao;

import com.trphn.core.model.Device;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

@SpringBootTest
public class JpaDeviceDaoTest {

    @Autowired
    private JpaDeviceDaoImpl underTest;

    @Test
    void testCreate() {
        
        Device device = new Device();
        device.setName("UnderCreateTestDeviceName");
        device.setBrand("UnderCreateTestDeviceBrand");
              
    
        Device actual = underTest.create(device);
        Device expected = underTest.findById(device.getId());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testDelete() {
        Device device = new Device();
        device.setName("UnderDeleteTestDeviceName");
        device.setBrand("UnderDeleteTestDeviceBrand");
        UUID id = underTest.create(device).getId();

        underTest.deleteById(id);

        Device actual = underTest.findById(device.getId());

        assertThat(actual).isNull();
    }   

    @Test
    void testFilter() {
        Device deviceA = new Device();
        deviceA.setName("UnderTestFilterDeviceAName");
        deviceA.setBrand("UnderTestFilterDeviceABrand");
        underTest.create(deviceA);
       
        int actual = underTest.filter(null, "UnderTestFilterDeviceA").size();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testFindAll() {

        int sizeBeforeCreate = underTest.findAll().size();
        underTest.create(new Device(null,"UnderTestFindAllDeviceAName","UnderTestFindAllDeviceABrand", null));
    
        int actual = underTest.findAll().size();
        int expected = sizeBeforeCreate+1;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testFindById() {
        Device device = new Device();
        device.setName("UnderFindByIdTestDeviceName");
        device.setBrand("UnderFindByIdTestDeviceBrand");
        
    
        Device actual =  underTest.create(device);
        Device expected = underTest.findById(actual.getId());

        assertThat(actual).isEqualTo(expected);
    }

    

    @Test
    void testUpdate() {
        Device deviceToCreate = new Device();
        deviceToCreate.setName("UnderUpdateTestDeviceName");
        deviceToCreate.setBrand("UnderUpdateTestDeviceBrand");    
        Device deviceToUpdate =  underTest.create(deviceToCreate);

        
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
