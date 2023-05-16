package com.team.appleplate.domain.store.dto;

import com.team.appleplate.domain.menu.dto.MenuResponseDto;
import com.team.appleplate.domain.store.domain.Address;
import com.team.appleplate.domain.store.domain.AreaCategory;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreResponseDto {

    private String name;

    private String storeNumber;

    private String storeCategory;

    private List<MenuResponseDto> menus;

    private String priceRange;

    private String businessTime;

    private String shopClosingDay;

    private String websiteAddress;

    private char parkingYn;

    private AreaCategory areaCategory;

    private Address address;

    public static StoreResponseDto fromEntity(Store store) {

        List<MenuResponseDto> menus = store.getMenus().stream().map(menu -> MenuResponseDto.builder()
                .name(menu.getName())
                .menuPrice(menu.getMenuPrice())
                .build()
        ).collect(Collectors.toList());

        return StoreResponseDto.builder()
                .name(store.getName())
                .storeNumber(store.getStoreNumber())
                .storeCategory(store.getStoreCategory())
                .menus(menus)
                .priceRange(store.getPriceRange())
                .businessTime(store.getBusinessTime())
                .shopClosingDay(store.getShopClosingDay())
                .websiteAddress(store.getWebsiteAddress())
                .parkingYn(store.getParkingYn())
                .areaCategory(store.getAreaCategory())
                .address(store.getAddress())
                .build();
    }
}