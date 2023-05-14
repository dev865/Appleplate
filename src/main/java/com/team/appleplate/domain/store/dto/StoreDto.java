package com.team.appleplate.domain.store.dto;


import com.team.appleplate.domain.menu.dto.MenuDto;
import com.team.appleplate.domain.store.domain.Address;
import com.team.appleplate.domain.store.domain.AreaCategory;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class StoreDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {

        private String name;

        private String storeNumber;

        private List<MenuDto.Response> menus;

        private String priceRange;

        private String businessTime;

        private String shopClosingDay;

        private String websiteAddress;

        private char parkingYn;

        private AreaCategory areaCategory;

        private Address address;

        public static StoreDto.Response fromEntity(Store store) {

            List<MenuDto.Response> menus = store.getMenus().stream().map(menu -> MenuDto.Response.builder()
                    .name(menu.getName())
                    .menuPrice(menu.getMenuPrice())
                    .menuCategory(menu.getMenuCategory())
                    .build()
            ).collect(Collectors.toList());

            return Response.builder()
                    .name(store.getName())
                    .storeNumber(store.getStoreNumber())
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
}
