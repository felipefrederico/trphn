package com.trphn.device.service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface Service<T> { 
    T save(T t);
    T findById(UUID id);
    Collection<T> findAll();
    T patch(UUID id, Map<Object, Object> fields);
    void deleteById(UUID id);
    Collection<T> filter(String brand, String name);
    T update(T t);
}
