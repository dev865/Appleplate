package com.team.appleplate.domain.store.domain;

import com.team.appleplate.domain.BaseTimeEntity;
import com.team.appleplate.domain.menu.domain.Menu;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    private String storeNumber;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    private String priceRange;

    private String businessTime;

    private String shopClosingDay;

    private String websiteAddress;

    private int hits;

    private Long grade;

    private char parkingYn;

    private char deleteYn;

    @Embedded
    private AreaCategory areaCategory;

    @Embedded
    private Address address;


}
