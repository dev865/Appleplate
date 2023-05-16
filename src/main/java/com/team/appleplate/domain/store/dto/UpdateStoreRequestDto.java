package com.team.appleplate.domain.store.dto;

import com.team.appleplate.domain.menu.dto.MenuRequestDto;
import com.team.appleplate.domain.store.domain.Address;
import com.team.appleplate.domain.store.domain.AreaCategory;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateStoreRequestDto {

    private String name;

    private String storeNumber;

    private String storeCategory;

    private List<MenuRequestDto> menus;

    private String priceRange;

    private String businessTime;

    private String shopClosingDay;

    private String websiteAddress;

    private char parkingYn;

    private AreaCategory areaCategory;

    private Address address;

}