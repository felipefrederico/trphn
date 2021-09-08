package com.trphn.core.service;

import java.util.Collection;
import java.util.UUID;

public interface IService<T> {
    T create(T t);
    T findById(UUID id);
    Collection<T> findAll();
    void deleteById(UUID id);
    Collection<T> filter(String brand, String name);
    T update(T t);
}
