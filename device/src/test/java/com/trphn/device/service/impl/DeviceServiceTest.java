package com.trphn.device.service.impl;

import java.util.UUID;

import com.trphn.core.dao.Dao;
import com.trphn.core.model.Device;
import com.trphn.device.service.DeviceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {

    @Mock
    private Dao<Device> deviceDao;

    @InjectMocks
    private DeviceServiceImpl underTest;

    @Test
    void testDeleteById() {
        UUID id = UUID.randomUUID();
        underTest.deleteById(id);
        ArgumentCaptor<UUID> deviceCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(deviceDao).deleteById(deviceCaptor.capture());
        assertThat(deviceCaptor.getValue()).isEqualTo(id);
    }

    @Test
    void testFilter() {
        String brand = "brand";
        String name = "name";
        underTest.filter(brand, name);
        ArgumentCaptor<String> deviceCaptor = ArgumentCaptor.forClass(String.class);
        verify(deviceDao).filter(deviceCaptor.capture(), deviceCaptor.capture());

        assertThat(deviceCaptor.getAllValues().get(0)).isEqualTo(brand);
        assertThat(deviceCaptor.getAllValues().get(1)).isEqualTo(name);
    }

    @Test
    void testFindAll() {
        underTest.findAll();
        verify(deviceDao).findAll();
    }

    @Test
    void testFindById() {
        UUID id = UUID.randomUUID();
        underTest.findById(id);
        ArgumentCaptor<UUID> deviceCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(deviceDao).findById(deviceCaptor.capture());
        assertThat(deviceCaptor.getValue()).isEqualTo(id);
    }

    @Test
    void testCreate() {
        Device device = new Device();
        device.setName("UnderDeleteTestDeviceName");
        device.setBrand("UnderDeleteTestDeviceBrand");

        underTest.create(device);
        ArgumentCaptor<Device> deviceCaptor = ArgumentCaptor.forClass(Device.class);
        verify(deviceDao).create(deviceCaptor.capture());
        assertThat(deviceCaptor.getValue()).isEqualTo(device);
    }

    @Test
    void testUpdate() {
        Device device = new Device();
        device.setName("UnderDeleteTestDeviceName");
        device.setBrand("UnderDeleteTestDeviceBrand");

        underTest.update(device);
        ArgumentCaptor<Device> deviceCaptor = ArgumentCaptor.forClass(Device.class);
        verify(deviceDao).update(deviceCaptor.capture());
        assertThat(deviceCaptor.getValue()).isEqualTo(device);
    }
}
