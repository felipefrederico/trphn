package com.trphn.device.model;

import java.time.Instant;
import java.util.UUID;

import com.trphn.core.model.Device;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DeviceTest {

    Device underTest;

    @Test
    void deviceAllArgsTests(){
        UUID expectedId = UUID.randomUUID();
        String expectedName = "underTest Name";
        String expectedBrand = "underTest Brand";
        Instant notExpectedCreationTime = null;
        underTest = new Device(expectedId, expectedName, expectedBrand, notExpectedCreationTime);

        assertThat( underTest.getId() ).isEqualTo(expectedId);
        assertThat( underTest.getName() ).isEqualTo(expectedName);
        assertThat( underTest.getBrand() ).isEqualTo(expectedBrand);
        assertThat( underTest.getCreationTime() ).isNotEqualTo(notExpectedCreationTime);
    }

    @Test
    void deviceNoArgsTests(){
        underTest = new Device();
        assertThat( underTest.getId() ).isNull();
        assertThat( underTest.getName() ).isNull();
        assertThat( underTest.getBrand() ).isNull();
        assertThat( underTest.getCreationTime() ).isNotNull();
    }
    
}
