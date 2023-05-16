package com.team.appleplate.domain.store.domain;

import com.team.appleplate.domain.BaseTimeEntity;
import com.team.appleplate.domain.menu.domain.Menu;
import com.team.appleplate.domain.store.dto.UpdateStoreRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private String storeCategory; // erd와 맞추기 위해 추가 Menu엔티티에 menuCategory를 변경 및 이동

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

    /**
     * 가게 수정
     */
    public Store updateStore(UpdateStoreRequestDto request) {
        List<Menu> updateMenus = this.menus.stream().map(menu -> menu.updateMenu(request.getMenus())).collect(Collectors.toList());

        this.name = request.getName();
        this.storeNumber = request.getStoreNumber();
        this.storeCategory = request.getStoreCategory();
        this.menus = updateMenus;
        this.priceRange = request.getPriceRange();
        this.businessTime = request.getBusinessTime();
        this.shopClosingDay = request.getShopClosingDay();
        this.websiteAddress = request.getWebsiteAddress();
        this.parkingYn = request.getParkingYn();

        return this;
    }

    /**
     * 가게 삭제
     */
    public void deleteStore(Long id) {
        this.name = "deleteStore" + id;
        this.deleteYn = 'Y';
    }

}
