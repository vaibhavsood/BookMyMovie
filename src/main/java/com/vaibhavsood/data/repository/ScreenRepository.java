package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Screen;
import org.springframework.data.repository.CrudRepository;

public interface ScreenRepository extends CrudRepository<Screen, Long> {
    public Screen findByScreenId(long screenId);
}
