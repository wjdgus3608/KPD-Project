package com.jung.app.randomnumberdb.repository;

import com.jung.domain.entity.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}
