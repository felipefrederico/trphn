package com.trphn.device.resource;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface Resource<T> {
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<T> create(@RequestBody T t);

    @GetMapping(value = "/{id}")
    ResponseEntity<T> findById(@PathVariable UUID id);

    @GetMapping(value = "/")
    ResponseEntity<Collection<T>> findAll();

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<T> update(@RequestBody T t);

    @PatchMapping(value = "/{id}")
    ResponseEntity<T> patch(@PathVariable UUID id, @RequestBody Map<Object, Object> fields);
       
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable UUID id);
    
    @GetMapping(value = "/filter/custom")
    ResponseEntity<Collection<T>> search(
        @RequestParam(value = "brand", required = false) String brand,
        @RequestParam(value = "name", required = false) String name
    );

}
