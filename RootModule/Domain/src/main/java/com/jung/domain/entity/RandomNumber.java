package com.jung.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class RandomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String parentId;
    @Column(nullable = false)
    private String childId;
    @Column(nullable = false)
    private String randomNumber;
}
