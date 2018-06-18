package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Screening;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findByScreeningDate(Date date);
}
