package com.team.appleplate.domain.store.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class AreaCategory {

    private String address_main_category;
    private String address_sub_category;
}
