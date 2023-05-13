package com.team.appleplate.domain.store.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String parcel_address;

    private String new_address;
}
