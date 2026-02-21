package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.entity.AbstractEntity;

import java.util.Collection;

public interface CrudService<T extends AbstractEntity> {

    Collection<T> findAll();
}
