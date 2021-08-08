package com.jung.repository;

import com.jung.domain.entity.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
    RandomNumber findByParentId(String parentId);
    RandomNumber findByChildId(String childId);
}
