package com.toy.javajive.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MemberEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column(length = 30)
    private String name;
}
