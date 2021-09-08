package com.trphn.device.dao;

import java.util.Collection;
import java.util.UUID;

public interface Dao<T> {
    T create(T t);
    Collection<T> findAll();
    T findById(UUID id);
    T update(T t);
    void deleteById(UUID t);
    Collection<T> filter(String brand, String name);
}