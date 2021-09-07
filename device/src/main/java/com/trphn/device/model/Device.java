package com.trphn.device.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

@Entity
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Device implements Persistable<UUID>{

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "The field 'name' is mandatory")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "The field 'brand' is mandatory")
    @Column(nullable = false)
    private String brand;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false)
    private Instant creationTime;

    public Device(UUID id, String name, String brand, Instant creationTime){
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.creationTime=Instant.now();
    }

    public Device(){
        this.creationTime=Instant.now();
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return id==null;
    }

}