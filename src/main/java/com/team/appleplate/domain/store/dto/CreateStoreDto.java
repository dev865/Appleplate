package com.team.appleplate.domain.store.dto;

import com.team.appleplate.domain.menu.domain.Menu;
import com.team.appleplate.domain.menu.dto.MenuDto;
import com.team.appleplate.domain.store.domain.Address;
import com.team.appleplate.domain.store.domain.AreaCategory;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

public class CreateStoreDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {

        @NotEmpty
        private String name;

        private String storeNumber;

        private List<MenuDto.Request> menus;

        private String priceRange;

        private String businessTime;

        private String shopClosingDay;

        private String websiteAddress;

        private char parkingYn;

        @Embedded
        private AreaCategory areaCategory;

        @Embedded
        private Address address;

        public  Store toEntity() {
            List<Menu> menus = this.menus.stream().map(menu -> menu.toEntity()).collect(Collectors.toList());

            return Store.builder()
                    .name(this.getName())
                    .storeNumber(this.getStoreNumber())
                    .menus(menus)
                    .priceRange(this.getPriceRange())
                    .businessTime(this.getBusinessTime())
                    .shopClosingDay(this.getShopClosingDay())
                    .websiteAddress(this.getWebsiteAddress())
                    .parkingYn(this.getParkingYn())
                    .areaCategory(this.getAreaCategory())
                    .address(this.getAddress())
                    .build();
        }

    }
}
