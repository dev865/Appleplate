package com.team.appleplate.domain.store.dto;

import com.team.appleplate.domain.menu.domain.Menu;
import com.team.appleplate.domain.menu.dto.MenuRequestDto;
import com.team.appleplate.domain.store.domain.Address;
import com.team.appleplate.domain.store.domain.AreaCategory;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateStoreRequestDto {

        @NotEmpty
        private String name;

        private String storeNumber;

        private String storeCategory;

        private List<MenuRequestDto> menus;

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
            List<Menu> menus = this.menus.stream().map(MenuRequestDto::toEntity).collect(Collectors.toList());

            return Store.builder()
                    .name(this.getName())
                    .storeNumber(this.getStoreNumber())
                    .storeCategory(this.getStoreCategory())
                    .menus(menus)
                    .priceRange(this.getPriceRange())
                    .businessTime(this.getBusinessTime())
                    .shopClosingDay(this.getShopClosingDay())
                    .websiteAddress(this.getWebsiteAddress())
                    .parkingYn(this.getParkingYn())
                    .deleteYn('N')
                    .areaCategory(this.getAreaCategory())
                    .address(this.getAddress())
                    .build();
        }
}
