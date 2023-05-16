package com.team.appleplate.domain.menu.domain;

import com.team.appleplate.domain.menu.dto.MenuRequestDto;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menu_name")
    private String name;

    private String menuPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    /**
     * 가게 등록(메뉴)
     */
    public void addStore(Store store) {
        this.store = store;
    }

    /**
     * 가게 메뉴 수정
     */
    public Menu updateMenu(List<MenuRequestDto> request) {
        for (MenuRequestDto menuRequestDto : request) {
            this.name = menuRequestDto.getName();
            this.menuPrice = menuRequestDto.getMenuPrice();
        }
        return this;
    }
}
