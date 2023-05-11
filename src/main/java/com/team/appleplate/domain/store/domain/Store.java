package com.team.appleplate.domain.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String name;

    @Builder(builderClassName = "ReviewRegisterStoreId", builderMethodName = "ReviewRegisterStoreId")
    public Store(Long storeId){
        this.storeId = storeId;
    }
}
